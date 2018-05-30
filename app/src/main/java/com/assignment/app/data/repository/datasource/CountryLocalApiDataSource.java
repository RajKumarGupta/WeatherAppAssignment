package com.assignment.app.data.repository.datasource;

import com.assignment.app.data.entity.CountryEntity;
import com.assignment.app.data.local.LocalApi;
import com.assignment.app.data.entity.CityEntity;
import io.reactivex.Observable;
import java.util.List;

public class CountryLocalApiDataSource implements DataSource {

  private final LocalApi localApi;

  public CountryLocalApiDataSource(LocalApi localApi) {
    this.localApi = localApi;
  }

  @Override public Observable<List<CountryEntity>> countryEntityList() {
    return this.localApi.countryEntityList();
  }

  @Override public Observable<CountryEntity> countryEntity(String country_name) {
    return this.localApi.countryEntity(country_name);
  }

  @Override
  public Observable<CityEntity> cityEntity(String country_id, String city_id) {
    return this.localApi.cityEntity(country_id,city_id);
  }
}
