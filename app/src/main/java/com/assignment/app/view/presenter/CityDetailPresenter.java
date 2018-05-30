package com.assignment.app.view.presenter;

import android.support.annotation.NonNull;
import com.assignment.app.domain.model.City;
import com.assignment.app.domain.usecase.GetCitiesDetailsByCityId;
import com.assignment.app.view.viewmodel.CityViewModel;
import com.assignment.app.view.viewmodel.mapper.CityViewModelToCityMapper;
import javax.inject.Inject;
import io.reactivex.observers.DisposableObserver;

public class CityDetailPresenter extends Presenter<CityDetailPresenter.View> {

    private final GetCitiesDetailsByCityId getCitiesDetailsByCityId;
    private final CityViewModelToCityMapper mapper;
    private String countryId, cityId;

    @Inject
    public CityDetailPresenter(@NonNull GetCitiesDetailsByCityId getCitiesDetailsByCityId,
                               @NonNull CityViewModelToCityMapper mapper) {
        this.getCitiesDetailsByCityId = getCitiesDetailsByCityId;
        this.mapper = mapper;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void initialize() {
        super.initialize();
        getView().showLoading();
        getCitiesDetailsByCityId.searchCityDetailbyCityId(countryId, cityId);
        getCitiesDetailsByCityId.execute(new DisposableObserver<City>() {

            @Override
            public void onComplete() {
                getView().hideLoading();
            }

            @Override
            public void onError(Throwable e) {
                getView().hideLoading();
            }

            @Override
            public void onNext(City city) {
                CityViewModel cityViewModel = mapper.reverseMap(city);
                getView().showCityDetail(cityViewModel);
            }
        });
    }

    public void setId(String country_id, String city_id) {
        this.countryId = country_id;
        this.cityId = city_id;
    }

    public void destroy() {
        this.getCitiesDetailsByCityId.dispose();
        setView(null);
    }

    public interface View extends Presenter.View {
        void showCityDetail(CityViewModel cityViewModel);
    }
}
