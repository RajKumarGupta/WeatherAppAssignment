package com.assignment.app.data.repository.datasource.mapper;

import com.assignment.app.data.entity.CountryEntity;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;
import javax.inject.Inject;

public class CountryEntityJsonMapper {

  private final Gson gson;

  @Inject public CountryEntityJsonMapper() {
    gson = new Gson();
  }

  public CountryEntity transformCountryEntity(String countryJsonResponse) throws JsonSyntaxException {
    CountryEntity countryEntity;
    try {
      Type typeCountryEntity = new TypeToken<CountryEntity>() {
      }.getType();
      countryEntity = this.gson.fromJson(countryJsonResponse, typeCountryEntity);
      return countryEntity;
    } catch (JsonSyntaxException exception) {
      exception.printStackTrace();
      throw exception;
    }
  }

  public List<CountryEntity> transformCountryEntityCollection(String countryListJsonResponse) throws JsonSyntaxException {

    List<CountryEntity> countryEntityList;
    try {
      Type typeCountryEntityList = new TypeToken<List<CountryEntity>>() {
      }.getType();
      countryEntityList = this.gson.fromJson(countryListJsonResponse, typeCountryEntityList);
      return countryEntityList;
    } catch (JsonSyntaxException exception) {
      exception.printStackTrace();
      throw exception;
    }

  }
}
