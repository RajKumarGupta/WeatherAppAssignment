package com.assignment.app.data.entity.mapper;

import com.assignment.app.data.entity.mapper.data.FakeTeamLocalAPI;
import com.assignment.app.data.entity.CountryEntity;
import com.assignment.app.data.repository.datasource.mapper.CountryEntityJsonMapper;
import com.google.gson.JsonSyntaxException;
import java.util.Collection;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CountryEntityJsonMapperTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    private CountryEntityJsonMapper countryEntityJsonMapper;

    @Before
    public void setUp() {
        countryEntityJsonMapper = new CountryEntityJsonMapper();
    }

    @Test
    public void givenTransformCollectionCountryEntityCorrectly() {

        final String FAKE_JSON_RESPONSE_COUNTRY_COLLECTION =
                FakeTeamLocalAPI.getJsonResponseCountryCollection();

        Collection<CountryEntity> countryEntities =
                countryEntityJsonMapper.transformCountryEntityCollection(FAKE_JSON_RESPONSE_COUNTRY_COLLECTION);
        final CountryEntity countryEntityOne = ((CountryEntity) countryEntities.toArray()[0]);
        final CountryEntity countryEntityTwo = ((CountryEntity) countryEntities.toArray()[1]);
        final CountryEntity countryEntityThree = ((CountryEntity) countryEntities.toArray()[2]);
        assertThat(countryEntityOne.getCountry_name(), is("Australia"));
        assertThat(countryEntityTwo.getCountry_name(), is("Cambodia"));
        assertThat(countryEntityThree.getCountry_name(), is("Hong Kong"));
        assertThat(countryEntities.size(), is(3));

    }

    @Test
    public void givenTransformTeamEntityCorrectly() {

        final String FAKE_JSON_RESPONSE_TEAM = FakeTeamLocalAPI.getJsonResponseCountry();
        CountryEntity countryEntity = countryEntityJsonMapper.transformCountryEntity(FAKE_JSON_RESPONSE_TEAM);
        assertThat(countryEntity.getCountry_name(), is("Australia"));
        assertThat(countryEntity.getFlag_image_url(), is("https://d3xm8g2fmv6ji.cloudfront.net/img/flags/australia@2x.png"));
        //you can try test each attribute is possible

    }

    @Test
    public void givenExpectedExceptionTransformUserEntityCollectionNotValidResponse() {
        expectedException.expect(JsonSyntaxException.class);
        countryEntityJsonMapper.transformCountryEntityCollection("Expects a json array like response");
    }

    @Test
    public void givenExpectedExceptionTransformUserEntityNotValidResponse() {
        expectedException.expect(JsonSyntaxException.class);
        countryEntityJsonMapper.transformCountryEntity("Expects a json object like response");
    }
}
