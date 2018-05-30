package com.assignment.app.domain;

import com.assignment.app.data.repository.CountryRepository;
import com.assignment.app.domain.usecase.GetCitiesByCountryName;

import io.reactivex.schedulers.Schedulers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class GetCitiesByCountryNameTest {

    private static final String ANY_COUNTRY_NAME_OF_COUNTRIES = "Australia";

    @Mock
    private CountryRepository repository;
    private GetCitiesByCountryName getCitiesByCountryName;

    @Before
    public void setup() {
        getCitiesByCountryName = givenACityByCountryNameUseCase();
    }

    @Test
    public void givenAConcreteUseCaseOfGetCityByCountryName() {
        assertThat(getCitiesByCountryName, instanceOf(GetCitiesByCountryName.class));
    }

    @Test
    public void getCityByCountryNameObservableFromRepository() {

        getCitiesByCountryName.searchCitiesbyCountryName(ANY_COUNTRY_NAME_OF_COUNTRIES);
        getCitiesByCountryName.createObservableUseCase();
        Mockito.verify(repository).country(ANY_COUNTRY_NAME_OF_COUNTRIES);
        Mockito.verifyNoMoreInteractions(repository);

    }

    private GetCitiesByCountryName givenACityByCountryNameUseCase() {
        return new GetCitiesByCountryName(Schedulers.trampoline(), Schedulers.trampoline(), repository);
    }
}
