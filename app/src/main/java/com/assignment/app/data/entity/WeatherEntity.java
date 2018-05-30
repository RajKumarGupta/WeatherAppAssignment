package com.assignment.app.data.entity;

import com.assignment.app.view.viewmodel.DailyModel;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

public class WeatherEntity {

    @SerializedName("currently") private CurrentlyEntity currently;
    @SerializedName("daily")
    private Map<String, DailyModel> daily;
    public CurrentlyEntity getCurrently() {
        return currently;
    }
    public void setCurrently(CurrentlyEntity currently) {
        this.currently = currently;
    }
    public Map<String, DailyModel> getDaily() {
        return daily;
    }
    public void setDaily(Map<String, DailyModel> daily) {
        this.daily = daily;
    }
}
