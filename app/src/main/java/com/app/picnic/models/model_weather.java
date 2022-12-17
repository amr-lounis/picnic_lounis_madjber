package com.app.picnic.models;

public class model_weather {
    String date;
    String weather;

    public model_weather(String date, String weather) {
        this.date = date;
        this.weather = weather;
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
}
