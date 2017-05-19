package com.example.ruslan.cpweather.api;

import com.example.ruslan.cpweather.api.pojo.WeatherPojo;
import com.example.ruslan.cpweather.model.City;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ruslan on 19.05.2017.
 */

public class OpenWeatherApiProvider {
    String BASE_URL = "http://api.openweathermap.org";

    private static OpenWeatherApiProvider openWeatherApiProvider;
    private OpenWeatherApiService openWeatherApiService;

    private OpenWeatherApiProvider(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        openWeatherApiService = retrofit.create(OpenWeatherApiService.class);
    }

    public Response<WeatherPojo> getWeather(City city) throws IOException {
        Call<WeatherPojo> call = openWeatherApiService.getWeather(city.getName());
        return call.execute();
    }

    public static OpenWeatherApiProvider getInstance(){
        if (openWeatherApiProvider == null){
            openWeatherApiProvider = new OpenWeatherApiProvider();
        }
        return openWeatherApiProvider;
    }
}
