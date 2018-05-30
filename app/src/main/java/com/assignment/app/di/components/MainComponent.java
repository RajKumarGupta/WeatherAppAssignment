package com.assignment.app.di.components;

import android.content.Context;
import com.assignment.app.view.activity.CountriesActivity;
import com.assignment.app.data.entity.CityEntity;
import com.assignment.app.di.modules.MainModule;
import com.assignment.app.view.activity.CitiesActivity;
import com.assignment.app.view.activity.CityDetailsActivity;
import dagger.Component;
import javax.inject.Singleton;

@Singleton
@Component(modules = MainModule.class)
public interface MainComponent {

    void inject(CountriesActivity activity);

    void inject(CitiesActivity activity);

    void inject(CityDetailsActivity activity);

    void inject(CityEntity entity);

    Context context();
}
