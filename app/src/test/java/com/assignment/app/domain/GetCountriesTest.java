package com.assignment.app.domain;

import com.assignment.app.data.repository.CountryRepository;
import com.assignment.app.domain.usecase.GetCountries;

import io.reactivex.schedulers.Schedulers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@RunWith(MockitoJUnitRunner.class)
public class GetCountriesTest {

    @Mock
    private CountryRepository repository;
    private GetCountries getCountries;

    @Before
    public void setUp() {
        getCountries = givenACountryListUseCase();
    }

    @Test
    public void givenAConcreteUseCaseOfGetCountries() {
        assertThat(getCountries, instanceOf(GetCountries.class));
    }

    @Test
    public void getCountryListObservableFromRepository() {
        getCountries.createObservableUseCase();
        verify(repository).countryList();
        verifyNoMoreInteractions(repository);
    }

    private GetCountries givenACountryListUseCase() {
        return new GetCountries(Schedulers.trampoline(), Schedulers.trampoline(), repository);
    }
}
