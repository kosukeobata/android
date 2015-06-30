package com.example.kosukeobata.watherforecasts;

import android.content.Context;
import android.net.http.AndroidHttpClient;
import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WeatherApi3 {

    private static final String USER_AGENT = "WeatherForecasts Sample";
    private static final String URL =
            "http://www.drk7.jp/weather/json/27.js";

    public static WeatherForecast getWeather(Context context, String pointId)
            throws IOException, JSONException {

        AndroidHttpClient client = AndroidHttpClient.newInstance(USER_AGENT, context);
        HttpGet get = new HttpGet(URL);

        StringBuilder sb = new StringBuilder();
        try{
            HttpResponse response = client.execute(get);

            BufferedReader br = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));

            String line = null;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        } finally {
            client.close();
        }

        Object obj = new JSONObject(sb.toString());

        Log.i("", obj.toString());

        return new WeatherForecast(new JSONObject(sb.toString()));
    }
}