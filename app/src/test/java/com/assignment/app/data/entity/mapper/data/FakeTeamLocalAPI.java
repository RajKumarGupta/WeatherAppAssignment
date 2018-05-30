package com.assignment.app.data.entity.mapper.data;

import com.assignment.app.data.entity.CountryEntity;

public class FakeTeamLocalAPI {

  private static final String JSON_RESPONSE_COUNTRY = "{\n"
          + "    \"country_id\": \"3\",\n"
          + "    \"flag_image_url\": \"https://d3xm8g2fmv6ji.cloudfront.net/img/flags/australia@2x.png\",\n"
          + "    \"country_name\": \"Australia\"\n"
          + "  }";

  private static final String JSON_RESPONSE_COUNTRY_COLLECTION = "[\n"
          + "  {\n"
          + "    \"country_id\": \"3\",\n"
          + "    \"flag_image_url\": \"https://d3xm8g2fmv6ji.cloudfront.net/img/flags/australia@2x.png\",\n"
          + "    \"country_name\": \"Australia\"\n"
          + "  },\n"
          + "  {\n"
          + "    \"country_id\": \"12\",\n"
          + "    \"flag_image_url\": \"https://d3xm8g2fmv6ji.cloudfront.net/img/flags/australia@2x.png\",\n"
          + "    \"country_name\": \"Cambodia\"\n"
          + "  },\n"
          + "  {\n"
          + "    \"country_id\": \"4\",\n"
          + "    \"flag_image_url\": \"https://d3xm8g2fmv6ji.cloudfront.net/img/flags/australia@2x.png\",\n"
          + "    \"country_name\": \"Hong Kong\"\n"
          + "\n"
          + "  }]";

  public static String getJsonResponseCountry() {
    return JSON_RESPONSE_COUNTRY;
  }

  public static String getJsonResponseCountryCollection() {
    return JSON_RESPONSE_COUNTRY_COLLECTION;
  }

  private final static String FAKE_COUNTRY_NAME = "Australia";
  private final static String FAKE_COUNTRY_IMG = "https://d3xm8g2fmv6ji.cloudfront.net/img/flags/australia@2x.png";

  public static CountryEntity getFakeTeamEntity() {


    CountryEntity countryEntity = new CountryEntity();
    countryEntity.setCountry_name(FAKE_COUNTRY_NAME);
    countryEntity.setFlag_image_url(FAKE_COUNTRY_IMG);

    return countryEntity;
  }
}