package com.assignment.app.data.repository;

import android.support.annotation.NonNull;
import com.assignment.app.data.repository.datasource.CountryDataSourceFactory;
import com.assignment.app.data.repository.datasource.DataSource;
import com.assignment.app.data.repository.datasource.mapper.CityToCityEntityMapper;
import com.assignment.app.data.repository.datasource.mapper.CountryToCountryEntityMapper;
import com.assignment.app.domain.model.City;
import com.assignment.app.domain.model.Country;

import io.reactivex.Observable;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class CountryRepository implements Repository {

    private final CountryToCountryEntityMapper countryToCountryEntityMapper;
    private final CityToCityEntityMapper cityToCityEntityMapper;
    private final DataSource dataSource;

    @Inject
    CountryRepository(@NonNull CountryDataSourceFactory countryDataSourceFactory,
                      @NonNull CountryToCountryEntityMapper countryToCountryEntityMapper, @NonNull CityToCityEntityMapper cityToCityEntityMapper) {
        this.countryToCountryEntityMapper = countryToCountryEntityMapper;
        this.cityToCityEntityMapper = cityToCityEntityMapper;
        this.dataSource = countryDataSourceFactory.createDataSource();
    }

    @Override
    public Observable<List<Country>> countryList() {
        return dataSource.countryEntityList().map(countryToCountryEntityMapper::reverseMap);
    }

    @Override
    public Observable<Country> country(String country_name) {
        return dataSource.countryEntity(country_name).map(countryToCountryEntityMapper::reverseMap);
    }

    @Override
    public Observable<City> cityDetail(String country_id, String city_id) {
        return dataSource.cityEntity(country_id, city_id).map(cityToCityEntityMapper::reverseMap);
    }
}
