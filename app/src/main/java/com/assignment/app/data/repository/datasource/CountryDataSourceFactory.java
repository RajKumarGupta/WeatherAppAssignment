
package com.assignment.app.data.repository.datasource;

import android.content.Context;
import android.support.annotation.NonNull;

import com.assignment.app.data.local.LocalImpl;
import com.assignment.app.data.repository.datasource.mapper.CountryEntityJsonMapper;

import javax.inject.Inject;
import javax.inject.Singleton;

 public class CountryDataSourceFactory {

  private final Context context;

  @Inject public CountryDataSourceFactory(@NonNull Context context) {
    this.context = context;
  }

  public DataSource createDataSource() {
    CountryEntityJsonMapper countryEntityJsonMapper = new CountryEntityJsonMapper();
    LocalImpl local = new LocalImpl(context, countryEntityJsonMapper);
    return new CountryLocalApiDataSource(local);
  }
}
