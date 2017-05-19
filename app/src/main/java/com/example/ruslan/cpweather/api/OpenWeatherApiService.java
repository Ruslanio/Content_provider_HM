package com.example.ruslan.cpweather.api;

import com.example.ruslan.cpweather.api.pojo.WeatherPojo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Ruslan on 19.05.2017.
 */

public interface OpenWeatherApiService {


    @GET("data/2.5/weather?appid=b9c967d7d9a3857960e1bcb6fbdb75ca")
    Call<WeatherPojo> getWeather(@Query("q") String cityName);
}
