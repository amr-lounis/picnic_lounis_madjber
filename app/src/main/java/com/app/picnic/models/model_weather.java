package com.app.picnic.models;

public class model_weather {
    private  int    id;
    private  String weather;
    private  Double  temp;

    public model_weather(int id, String weather, Double temp) {
        this.id = id;
        this.weather = weather;
        this.temp = temp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }
}
