package com.assignment.app.view.viewmodel.mapper;

import com.assignment.app.data.repository.datasource.mapper.Mapper;
import com.assignment.app.domain.model.City;
import com.assignment.app.view.viewmodel.CityViewModel;
import javax.inject.Inject;

public class CityViewModelToCityMapper extends Mapper<CityViewModel, City> {

  @Inject
  CityViewModelToCityMapper() {
  }

  @Override public City map(CityViewModel value) {
    throw new UnsupportedOperationException();
  }

  @Override
  public CityViewModel reverseMap(City value) {

    CityViewModel cityViewModel = new CityViewModel();
    cityViewModel.setCity_id(value.getCity_id());
    cityViewModel.setActive_flag(value.getActive_flag());
    cityViewModel.setCity_name(value.getCity_name());
    cityViewModel.setWeather(value.getWeather());

    return cityViewModel;
  }

}
