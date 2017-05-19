package com.example.ruslan.cpweather.service;

import com.example.ruslan.cpweather.model.City;
import com.example.ruslan.cpweather.model.Weather;

/**
 * Created by Ruslan on 19.05.2017.
 */

public interface WeatherService {

    Weather get(City city);

    void add(Weather weather);

    void remove(String cityName);
}
