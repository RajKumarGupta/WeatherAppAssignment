package com.assignment.app.view.presenter;

import android.support.annotation.NonNull;
import com.assignment.app.data.entity.CityEntity;
import com.assignment.app.domain.model.Country;
import com.assignment.app.domain.usecase.GetCitiesByCountryName;
import com.assignment.app.view.viewmodel.CountryViewModel;
import com.assignment.app.view.viewmodel.mapper.CountryViewModelToCountryMapper;
import javax.inject.Inject;
import io.reactivex.observers.DisposableObserver;

public class CityPresenter extends Presenter<CityPresenter.View> {

    private final GetCitiesByCountryName getCitiesByCountryName;
    private final CountryViewModelToCountryMapper mapper;
    private String countryNameFlag;

    @Inject
    public CityPresenter(@NonNull GetCitiesByCountryName getCitiesByCountryName,
                         @NonNull CountryViewModelToCountryMapper mapper) {
        this.getCitiesByCountryName = getCitiesByCountryName;
        this.mapper = mapper;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void initialize() {
        super.initialize();
        getView().showLoading();
        getCitiesByCountryName.searchCitiesbyCountryName(countryNameFlag);

        getCitiesByCountryName.execute(new DisposableObserver<Country>() {
            @Override
            public void onComplete() {
                getView().hideLoading();
            }

            @Override
            public void onError(Throwable e) {
                getView().hideLoading();
            }

            @Override
            public void onNext(Country country) {

                CountryViewModel countryViewModel = mapper.reverseMap(country);
                getView().showCity(countryViewModel);

            }
        });
    }

    public void setCountryNameFlag(String countryNameFlag) {
        this.countryNameFlag = countryNameFlag;
    }

    public void destroy() {
        this.getCitiesByCountryName.dispose();
        setView(null);
    }

    public void onItemClicked(CityEntity city) {

        getView().openCityDetailScreen(city);

    }

    public interface View extends Presenter.View {

        void showCity(CountryViewModel countryViewModel);

        void openCityDetailScreen(CityEntity cityEntity);
    }
}
