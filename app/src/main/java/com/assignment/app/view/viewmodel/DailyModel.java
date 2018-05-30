package com.assignment.app.view.viewmodel;

import com.google.gson.annotations.SerializedName;

public class DailyModel {

    @SerializedName("summary")
    private String summary;
    @SerializedName("humidity")
    private String humidity;
    @SerializedName("longitude")
    private String longitude;
    @SerializedName("iconUrl")
    private String iconUrl;
    @SerializedName("tempMaxCelcius")
    private String tempMaxCelcius;
    @SerializedName("tempMinCelcius")
    private String tempMinCelcius;
    @SerializedName("tempCelsius")
    private String tempCelsius;
    @SerializedName("latitude")
    private String latitude;
    @SerializedName("timeString")
    private String timeString;

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getTempMaxCelcius() {
        return tempMaxCelcius;
    }

    public void setTempMaxCelcius(String tempMaxCelcius) {
        this.tempMaxCelcius = tempMaxCelcius;
    }

    public String getTempMinCelcius() {
        return tempMinCelcius;
    }

    public void setTempMinCelcius(String tempMinCelcius) {
        this.tempMinCelcius = tempMinCelcius;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getTimeString() {
        return timeString;
    }

    public void setTimeString(String timeString) {
        this.timeString = timeString;
    }

    public String getTempCelsius() {
        return tempCelsius;
    }

    public void setTempCelsius(String tempCelsius) {
        this.tempCelsius = tempCelsius;
    }
}
