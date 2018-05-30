package com.assignment.app.data.repository;

import com.assignment.app.data.entity.CountryEntity;
import com.assignment.app.data.local.LocalApi;
import com.assignment.app.data.repository.datasource.CountryLocalApiDataSource;

import io.reactivex.Observable;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CountryLocalApiDataSourceTest {

    private static final String ANY_COUNTRY_NAME_OF_COUNTRY_ENTITY = "Australia";

    @Mock
    private LocalApi localApi;

    private CountryLocalApiDataSource localApiDataSource;

    @Before
    public void setUp() {
        localApiDataSource = new CountryLocalApiDataSource(localApi);
    }

    @Test
    public void givenACountryEntityListFromLocalApi() {
        localApiDataSource.countryEntityList();
        verify(localApi).countryEntityList();
    }

    @Test
    public void givenACountryEntityByCountryNameLocalApi() {
        localApiDataSource.countryEntity(ANY_COUNTRY_NAME_OF_COUNTRY_ENTITY);
        verify(localApi).countryEntity(ANY_COUNTRY_NAME_OF_COUNTRY_ENTITY);
    }

    @Test
    public void givenAnObservableCollectionCountryEntity() {
        List<CountryEntity> entities = new ArrayList<>();
        Observable<List<CountryEntity>> fakeListObservable = Observable.just(entities);
        given(localApi.countryEntityList()).willReturn(fakeListObservable);
    }

    @Test
    public void givenAnObservableCountryEntity() {
        CountryEntity fakeEntity = new CountryEntity();
        Observable<CountryEntity> fakeObservable = Observable.just(fakeEntity);
        given(localApi.countryEntity(ANY_COUNTRY_NAME_OF_COUNTRY_ENTITY)).willReturn(fakeObservable);
    }
}
