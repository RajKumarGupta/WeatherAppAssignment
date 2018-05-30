package com.assignment.app.domain.usecase;

import com.assignment.app.data.repository.Repository;
import com.assignment.app.domain.model.Country;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import javax.inject.Inject;
import javax.inject.Named;

public class GetCitiesByCountryName extends UseCase<Country> {

    private final Repository repository;
    private String country_name = "";

    @Inject
    public GetCitiesByCountryName(@Named("executor_thread") Scheduler executorThread,
                                  @Named("ui_thread") Scheduler uiThread, Repository repository) {
        super(executorThread, uiThread);
        this.repository = repository;
    }

    public void searchCitiesbyCountryName(String country_name) {
        this.country_name = country_name;
    }

    @Override
    public Observable<Country> createObservableUseCase() {
        return this.repository.country(country_name);
    }
}
