package com.assignment.app.domain.usecase;

import com.assignment.app.data.repository.Repository;
import com.assignment.app.domain.model.Country;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

public class GetCountries extends UseCase<List<Country>> {

    private final Repository repository;

    @Inject
    public GetCountries(@Named("executor_thread") Scheduler executorThread,
                        @Named("ui_thread") Scheduler uiThread, Repository repository) {
        super(executorThread, uiThread);
        this.repository = repository;
    }

    @Override
    public Observable<List<Country>> createObservableUseCase() {
        return this.repository.countryList();
    }
}
