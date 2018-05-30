package com.assignment.app.view.presenter;

import android.support.annotation.NonNull;

import com.assignment.app.domain.model.Country;
import com.assignment.app.domain.usecase.GetCountries;
import com.assignment.app.view.viewmodel.CountryViewModel;
import com.assignment.app.view.viewmodel.mapper.CountryViewModelToCountryMapper;
import io.reactivex.observers.DisposableObserver;
import java.util.List;
import javax.inject.Inject;

public class CountryPresenter extends Presenter<CountryPresenter.View> {

    private GetCountries getCountries;
    private CountryViewModelToCountryMapper mapper;

    @Inject
    public CountryPresenter(@NonNull GetCountries getCountries,
                            @NonNull CountryViewModelToCountryMapper mapper) {
        this.getCountries = getCountries;
        this.mapper = mapper;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void initialize() {

        super.initialize();
        getView().showLoading();

        getCountries.execute(new DisposableObserver<List<Country>>() {

            @Override
            public void onNext(List<Country> countries) {
                List<CountryViewModel> countryViewModels = mapper.reverseMap(countries);
                getView().showCountryList(countryViewModels);
            }

            @Override
            public void onError(Throwable e) {
                getView().hideLoading();
                e.printStackTrace();
            }

            @Override
            public void onComplete() {
                getView().hideLoading();
            }
        });

    }

    public void onCountryClicked(CountryViewModel countryViewModel) {

        getView().openCityListScreen(countryViewModel);
    }

    public void destroy() {
        this.getCountries.dispose();
        setView(null);
    }

    public interface View extends Presenter.View {

        void showCountryList(List<CountryViewModel> countryViewModelList);

        void openCityListScreen(CountryViewModel countryViewModel);
    }
}
