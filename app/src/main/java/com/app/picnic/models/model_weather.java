package com.app.picnic.models;

public class model_weather {
    private  int    id;
    private  String weather;
    private  Double  temp;
    private  String icon;

    public model_weather(int id, String weather, Double temp, String icon) {
        this.id = id;
        this.weather = weather;
        this.temp = temp;
        this.icon = icon;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
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
