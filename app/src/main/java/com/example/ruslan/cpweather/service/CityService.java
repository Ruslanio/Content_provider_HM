package com.example.ruslan.cpweather.service;

import com.example.ruslan.cpweather.model.City;

import java.util.List;

/**
 * Created by Ruslan on 19.05.2017.
 */

public interface CityService {

    List<City> getAll();

    void add(City city);

    void remove(City city);
}
