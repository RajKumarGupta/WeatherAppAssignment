package com.assignment.app.domain.model;

import com.assignment.app.data.entity.CityEntity;
import java.util.List;

public class Country {

    private String country_id;
    private String flag_image_url;
    private String country_name;
    private List<CityEntity> cities;

    public List<CityEntity> getCities() {
        return cities;
    }

    public void setCities(List<CityEntity> cities) {
        this.cities = cities;
    }

    public String getCountry_id() {
        return country_id;
    }

    public void setCountry_id(String country_id) {
        this.country_id = country_id;
    }

    public String getFlag_image_url() {
        return flag_image_url;
    }

    public void setFlag_image_url(String flag_image_url) {
        this.flag_image_url = flag_image_url;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }
}
