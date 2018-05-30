package com.assignment.app.data.repository.datasource;

import com.assignment.app.data.entity.CountryEntity;
import com.assignment.app.data.entity.CityEntity;
import java.util.List;
import io.reactivex.Observable;

public interface DataSource {

  Observable<List<CountryEntity>> countryEntityList();

  Observable<CountryEntity> countryEntity(final String country_name);

  Observable<CityEntity> cityEntity(final String country_id, final String city_id);
}
