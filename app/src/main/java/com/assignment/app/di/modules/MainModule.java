package com.assignment.app.di.modules;

import android.content.Context;
import com.assignment.app.WeatherApplication;
import com.assignment.app.data.repository.CountryRepository;
import com.assignment.app.data.repository.Repository;
import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import javax.inject.Named;
import javax.inject.Singleton;

@Module
public class MainModule {

    private final WeatherApplication weatherApplication;

    public MainModule(WeatherApplication weatherApplication) {
        this.weatherApplication = weatherApplication;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return weatherApplication;
    }

    @Provides
    @Singleton
    Repository provideRepository(CountryRepository countryRepository) {
        return countryRepository;
    }

    @Provides
    @Named("executor_thread")
    Scheduler provideExecutorThread() {
        return Schedulers.io();
    }

    @Provides
    @Named("ui_thread")
    Scheduler provideUiThread() {
        return AndroidSchedulers.mainThread();
    }
}
