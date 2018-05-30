package com.assignment.app.data.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CityEntity {

    @SerializedName("suggested_cities")
    private List<SuggestedCityEntity> suggested_cities;
    @SerializedName("active_flag")
    private String active_flag;
    @SerializedName("city_name")
    private String city_name;
    @SerializedName("city_id")
    private String city_id;
    @SerializedName("weather")
    private WeatherEntity weather;

    public List<SuggestedCityEntity> getSuggested_cities() {
        return suggested_cities;
    }

    public void setSuggested_cities(List<SuggestedCityEntity> suggested_cities) {
        this.suggested_cities = suggested_cities;
    }

    public String getActive_flag() {
        return active_flag;
    }

    public void setActive_flag(String active_flag) {
        this.active_flag = active_flag;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public void setCity_id(String city_id) {
        this.city_id = city_id;
    }

    public void setWeather(WeatherEntity weather) {
        this.weather = weather;
    }

    public String getCity_id() {
        return city_id;
    }

    public WeatherEntity getWeather() {
        return weather;
    }
}
