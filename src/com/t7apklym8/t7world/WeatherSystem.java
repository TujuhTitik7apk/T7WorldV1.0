package com.t7apklym8.t7world;

import java.util.Random;

public class WeatherSystem {

    private String weather;

    public WeatherSystem() {
        updateWeather();
    }

    public void updateWeather() {
        String[] weatherTypes = {"Cerah", "Hujan", "Badai", "Berkabut"};
        Random random = new Random();
        weather = weatherTypes[random.nextInt(weatherTypes.length)];
    }

    public String getWeather() {
        return weather;
    }
}