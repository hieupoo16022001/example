package com.example.asigment.model;

public class Weather {
    private String DateTime;
    private int WeatherIcon;
    private Temperature Temperature;

    public String getDateTime() {
        return DateTime;
    }

    public void setDateTime(String dateTime) {
        DateTime = dateTime;
    }

    public int getWeatherIcon() {
        return WeatherIcon;
    }

    public void setWeatherIcon(int weatherIcon) {
        WeatherIcon = weatherIcon;
    }

    public com.example.asigment.model.Temperature getTemperature() {
        return Temperature;
    }

    public void setTemperature(com.example.asigment.model.Temperature temperature) {
        Temperature = temperature;
    }
}
