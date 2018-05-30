package com.assignment.app.data.repository.datasource.mapper;

import com.assignment.app.data.entity.CountryEntity;
import com.assignment.app.domain.model.Country;
import javax.inject.Inject;
import javax.inject.Singleton;

public class CountryToCountryEntityMapper extends Mapper<Country, CountryEntity> {

  @Inject public CountryToCountryEntityMapper() {
  }

  @Override public CountryEntity map(Country value) {
    throw new UnsupportedOperationException();
  }

  @Override public Country reverseMap(CountryEntity entity) {

    Country country = new Country();
    country.setFlag_image_url(entity.getFlag_image_url());
    country.setCountry_name(entity.getCountry_name());
    country.setCountry_id(entity.getCountry_id());
    country.setCities(entity.getCities());

    return country;

  }
}
