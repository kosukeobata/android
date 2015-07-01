package com.example.kosukeobata.watherforecasts;

import android.content.Context;
import android.os.AsyncTask;

import  java.io.IOException;
import org.json.JSONException;

public class GetWeatherForecastApiTask extends AsyncTask<String, Void, WeatherForecast>{

    private final Context context;
    Exception exception;

    public GetWeatherForecastApiTask(Context context) {
        this.context = context;
    }

    @Override
    protected WeatherForecast doInBackground(String... params) {
        try {
<<<<<<< HEAD
            return WeatherApi.getWeather(context, params[0]);
=======
            return WeatherApi3.getWeather(context, params[0]);
>>>>>>> 90e3125dfeaaaad3c8f2dd967bff58a9d4fde4b0
        } catch (IOException e) {
            exception = e;
        } catch (JSONException e) {
            exception = e;
        }
        return null;
    }
}