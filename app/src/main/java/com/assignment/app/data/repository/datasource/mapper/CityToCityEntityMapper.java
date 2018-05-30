package com.assignment.app.data.repository.datasource.mapper;

import com.assignment.app.data.entity.CityEntity;
import com.assignment.app.data.entity.CityEntity;
import com.assignment.app.data.entity.CountryEntity;
import com.assignment.app.domain.model.City;
import com.assignment.app.domain.model.Country;

import javax.inject.Inject;
import javax.inject.Singleton;

public class CityToCityEntityMapper extends Mapper<City, CityEntity> {

  @Inject public CityToCityEntityMapper() {
  }

  @Override
  public CityEntity map(City value) {
    throw new UnsupportedOperationException();
  }

  @Override
  public City reverseMap(CityEntity entity) {

    City city = new City();
    city.setActive_flag(entity.getActive_flag());
    city.setCity_id(entity.getCity_id());
    city.setCity_name(entity.getCity_name());
    city.setWeather(entity.getWeather());
    return city;
  }
}

