package com.assignment.app.domain.usecase;

import com.assignment.app.data.repository.Repository;
import com.assignment.app.domain.model.City;
import javax.inject.Inject;
import javax.inject.Named;
import io.reactivex.Observable;
import io.reactivex.Scheduler;

public class GetCitiesDetailsByCityId extends UseCase<City> {

    private final Repository repository;
    private String city_id = "";
    private String country_id = "";

    @Inject
    public GetCitiesDetailsByCityId(@Named("executor_thread") Scheduler executorThread,
                                    @Named("ui_thread") Scheduler uiThread, Repository repository) {
        super(executorThread, uiThread);
        this.repository = repository;
    }

    public void searchCityDetailbyCityId(String country_id, String city_id) {
        this.country_id = country_id;
        this.city_id = city_id;
    }

    @Override
    public Observable<City> createObservableUseCase() {

        return this.repository.cityDetail(country_id, city_id);

    }
}
