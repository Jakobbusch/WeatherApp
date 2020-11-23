package com.example.appassignment.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class APIResponse {

    @SerializedName("current")
    @Expose
    private Current current;


    public Weather getWeather(){
        return new Weather(current.temp_c,current.feelslike_c,current.wind_kph,current.wind_dir,current.humidity,current.cloud,current.last_updated);
    }

    private class Current{
        private String temp_c;
        private String last_updated;
        private String wind_kph;
        private String wind_dir;
        private String humidity;
        private String cloud;
        private String feelslike_c;
    }
}
