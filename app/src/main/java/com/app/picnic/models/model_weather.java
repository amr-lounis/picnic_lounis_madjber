package com.app.picnic.models;

public class model_weather {
    String date;

    public model_weather(String date, String weather, String clouds, String wind, String visibility) {
        this.date = date;
        this.weather = weather;
        this.clouds = clouds;
        this.wind = wind;
        this.visibility = visibility;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getClouds() {
        return clouds;
    }

    public void setClouds(String clouds) {
        this.clouds = clouds;
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    String weather;
    String clouds;
    String wind;
    String visibility;
}
