package com.example.ruslan.cpweather.receiver;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.ruslan.cpweather.api.OpenWeatherApiProvider;
import com.example.ruslan.cpweather.api.pojo.WeatherPojo;
import com.example.ruslan.cpweather.database.CityContract;
import com.example.ruslan.cpweather.model.City;
import com.example.ruslan.cpweather.model.Weather;
import com.example.ruslan.cpweather.service.CityService;
import com.example.ruslan.cpweather.service.CityServiceImplCP;
import com.example.ruslan.cpweather.service.WeatherService;
import com.example.ruslan.cpweather.service.WeatherServiceImplCP;

import java.io.IOException;
import java.util.Date;

import retrofit2.Response;

/**
 * Created by Ruslan on 19.05.2017.
 */

public class MainIntentService extends IntentService {

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     *  Used to name the worker thread, important only for debugging.
     */
    public MainIntentService() {
        super(MainIntentService.class.getName());
    }
    public static final String ACTION_UPDATED = "action.update";

    public static void start(Context context,  City city) {

        Intent intent = new Intent(context, MainIntentService.class);
        CityContract.insertToIntent(intent, city);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        WeatherService weatherService = new WeatherServiceImplCP(getApplicationContext());
        CityService cityService = new CityServiceImplCP(getApplicationContext());

        String status = MainReceiver.STATUS_FAIL;
        City city =CityContract.fromIntent(intent);
        OpenWeatherApiProvider apiProvider = OpenWeatherApiProvider.getInstance();

        try {
            Response<WeatherPojo> response = apiProvider.getWeather(city);
            if (response.isSuccessful()){
                WeatherPojo weatherPojo = response.body();
                Weather weather = new Weather(new Date(System.currentTimeMillis()),
                        city.getName(),
                        weatherPojo.getSys().getCountry(),
                        weatherPojo.getMain().getTemp() - 273);

                weatherService.remove(city.getName());
                weatherService.add(weather);
                status = MainReceiver.STATUS_OK;
            }else {
                status = MainReceiver.STATUS_FAIL;
            }
        } catch (IOException e) {
            e.printStackTrace();
            status = MainReceiver.STATUS_FAIL;
        }

        Intent brIntent = new Intent(ACTION_UPDATED);
        brIntent.putExtra(MainReceiver.STATUS_KEY,status);
        sendBroadcast(brIntent);
    }
}
