package com.assignment.app.data.entity.mapper;

import com.assignment.app.data.entity.mapper.data.FakeTeamLocalAPI;
import com.assignment.app.data.entity.CountryEntity;
import com.assignment.app.data.repository.datasource.mapper.CountryToCountryEntityMapper;
import com.assignment.app.domain.model.Country;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class CountryToCountryEntityMapperTest {

    private final static String FAKE_COUNTRY_NAME = "Australia";
    private final static String FAKE_COUNTRY_IMG = "https://d3xm8g2fmv6ji.cloudfront.net/img/flags/australia@2x.png";

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private CountryToCountryEntityMapper countryToCountryEntityMapper;

    @Before
    public void setUp() {

        countryToCountryEntityMapper = new CountryToCountryEntityMapper();
    }

    @Test
    public void givenTransformTeamEntityToTeam() {

        CountryEntity countryEntity = FakeTeamLocalAPI.getFakeTeamEntity();
        Country country = countryToCountryEntityMapper.reverseMap(countryEntity);
        assertThat(country, is(instanceOf(Country.class)));
        assertThat(country.getFlag_image_url(), is(FAKE_COUNTRY_IMG));
        assertThat(country.getCountry_name(), is(FAKE_COUNTRY_NAME));
    }

    @Test
    public void givenExpectedExceptionTransformUserEntityCollectionNotValidResponse() {
        expectedException.expect(UnsupportedOperationException.class);
        countryToCountryEntityMapper.map(new Country());
    }
}
