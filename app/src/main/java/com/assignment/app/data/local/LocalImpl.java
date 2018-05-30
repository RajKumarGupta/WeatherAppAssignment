package com.assignment.app.data.local;

import android.content.Context;
import android.support.annotation.NonNull;

import com.assignment.app.data.entity.CountryEntity;
import com.assignment.app.data.entity.CityEntity;
import com.assignment.app.data.entity.CountryEntity;
import com.assignment.app.data.repository.datasource.mapper.CountryEntityJsonMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import io.reactivex.Observable;

public class LocalImpl implements LocalApi {

    private final Context context;
    private final CountryEntityJsonMapper countryEntityJsonMapper;

    public LocalImpl(@NonNull Context context, @NonNull CountryEntityJsonMapper countryEntityJsonMapper) {
        this.context = context;
        this.countryEntityJsonMapper = countryEntityJsonMapper;
    }

    @Override
    public Observable<List<CountryEntity>> countryEntityList() {
        return Observable.create(emitter -> {
            List<CountryEntity> countryEntityList = getAll();
            if (countryEntityList != null) {
                emitter.onNext(countryEntityList);
                emitter.onComplete();
            } else {
                emitter.onError(
                        new Throwable("Error getting country list from the local json (country_data.json)"));
            }
        });
    }

    @Override
    public Observable<CountryEntity> countryEntity(final String country_name) {
        return Observable.create(emitter -> {
            CountryEntity countryEntity = getByCountryName(country_name);
            if (countryEntity != null) {
                emitter.onNext(countryEntity);
                emitter.onComplete();
            } else {
                emitter.onError(
                        new Throwable("Error getting country data by country name from the local json (country_data.json)"));
            }
        });
    }

    @Override
    public Observable<CityEntity> cityEntity(final String country_id, final String city_id) {
        return Observable.create(emitter -> {
            CityEntity cityEntity = getById(country_id, city_id);
            if (cityEntity != null) {
                emitter.onNext(cityEntity);
                emitter.onComplete();
            } else {
                emitter.onError(
                        new Throwable("Error getting city data by city and country id from the local json (country_data.json)"));
            }
        });
    }


    private List<CountryEntity> getAll() {
        return countryEntityJsonMapper.transformCountryEntityCollection(getResponseFromLocalJson());
    }

    private CountryEntity getByCountryName(String country_name) {
        CountryEntity result = null;

        for (CountryEntity entity : getAll()) {
            if (entity.getCountry_name().equals(country_name)) {
                result = entity;
                break;
            }
        }
        return result;
    }

    private CityEntity getById(String country_id, String city_id) {

        CityEntity result = null;

        for (CountryEntity entity : getAll()) {

            if (entity.getCountry_id().equals(country_id)) {

                for (int i = 0; i < entity.getCities().size(); i++) {
                    if (entity.getCities().get(i).getCity_id().equals(city_id)) {
                        result = entity.getCities().get(i);
                        break;
                    }
                }
                break;
            }
        }
        return result;
    }

    private String getResponseFromLocalJson() {

        final String Country_DATA_FILE = "country_data.json";
        String str = "";

        try {
            StringBuilder builder = new StringBuilder();
            InputStream json = context.getAssets().open(Country_DATA_FILE);
            BufferedReader in = new BufferedReader(new InputStreamReader(json));

            while ((str = in.readLine()) != null) {
                builder.append(str);
            }
            in.close();
            str = builder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}