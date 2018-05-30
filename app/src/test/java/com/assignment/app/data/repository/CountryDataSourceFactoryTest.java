package com.assignment.app.data.repository;

import com.assignment.app.data.repository.datasource.CountryDataSourceFactory;
import com.assignment.app.data.repository.datasource.DataSource;
import com.assignment.app.data.repository.datasource.CountryLocalApiDataSource;

import org.junit.Before;
import org.junit.Test;
import org.robolectric.RuntimeEnvironment;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class CountryDataSourceFactoryTest {

    private CountryDataSourceFactory countryDataSourceFactory;

    @Before
    public void setUp() {
        countryDataSourceFactory = new CountryDataSourceFactory(RuntimeEnvironment.application);
    }

    @Test
    public void givenAnInstanceCountriesLocalApiDataSource() {
        DataSource dataSource = countryDataSourceFactory.createDataSource();
        assertThat(dataSource, is(notNullValue()));
        assertThat(dataSource, is(instanceOf(CountryLocalApiDataSource.class)));
    }
}
