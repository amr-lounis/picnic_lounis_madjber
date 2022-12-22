package com.app.picnic.models;

public class model_weather {
    private  int    id;
    private  String weather;
    private  Double  temp;
    private  Double  wind;
    private  Double  visibility;
    private  Double  snow;

    public model_weather(int id, String weather, Double temp, Double wind, Double visibility, Double snow) {
        this.id = id;
        this.weather = weather;
        this.temp = temp;
        this.wind = wind;
        this.visibility = visibility;
        this.snow = snow;
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

    public Double getWind() {
        return wind;
    }

    public void setWind(Double wind) {
        this.wind = wind;
    }

    public Double getVisibility() {
        return visibility;
    }

    public void setVisibility(Double visibility) {
        this.visibility = visibility;
    }

    public Double getSnow() {
        return snow;
    }

    public void setSnow(Double snow) {
        this.snow = snow;
    }
}
