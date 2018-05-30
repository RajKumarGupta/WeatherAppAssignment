package com.assignment.app.data.repository;

import com.assignment.app.domain.model.Country;
import com.assignment.app.domain.model.City;
import io.reactivex.Observable;
import java.util.List;

public interface Repository {

    Observable<List<Country>> countryList();

    Observable<Country> country(final String country_name);

    Observable<City> cityDetail(String country_id, final String city_id);
}
