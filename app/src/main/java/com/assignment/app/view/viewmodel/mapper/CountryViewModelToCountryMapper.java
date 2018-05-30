package com.assignment.app.view.viewmodel.mapper;

import com.assignment.app.data.repository.datasource.mapper.Mapper;
import com.assignment.app.domain.model.Country;
import com.assignment.app.view.viewmodel.CountryViewModel;
import javax.inject.Inject;

public class CountryViewModelToCountryMapper extends Mapper<CountryViewModel, Country> {

  @Inject
  CountryViewModelToCountryMapper() {
  }

  @Override public Country map(CountryViewModel value) {
    throw new UnsupportedOperationException();
  }

  @Override public CountryViewModel reverseMap(Country value) {

    CountryViewModel countryViewModel = new CountryViewModel();
    countryViewModel.setCountry_id(value.getCountry_id());
    countryViewModel.setCountry_name(value.getCountry_name());
    countryViewModel.setFlag_image_url(value.getFlag_image_url());
    countryViewModel.setCities(value.getCities());

    return countryViewModel;
  }
}
