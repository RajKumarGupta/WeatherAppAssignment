package com.assignment.app.data.local;

import com.assignment.app.data.entity.CountryEntity;
import com.assignment.app.data.entity.CityEntity;
import com.assignment.app.data.entity.CountryEntity;

import io.reactivex.Observable;

import java.util.List;

public interface LocalApi {

    Observable<List<CountryEntity>> countryEntityList();

    Observable<CountryEntity> countryEntity(final String country_name);

    Observable<CityEntity> cityEntity(final String country_id, final String city_id);
}
