package com.example.kosukeobata.watherforecasts;

import android.content.Context;
import android.net.http.AndroidHttpClient;
import android.util.Log;

import net.arnx.jsonic.JSON;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class WeatherApi2 {

    private static final String USER_AGENT = "WeatherForecasts Sample";
    private static final String URL =
            "http://www.drk7.jp/weather/xml/28.xml";

    public static WeatherForecast getWeather(Context context, String pointId)
            throws IOException, JSONException {

        AndroidHttpClient client = AndroidHttpClient.newInstance(USER_AGENT, context);
        HttpGet get = new HttpGet(URL);

        String json = null;
        try {
            HttpResponse response = client.execute(get);
            InputStream is = response.getEntity().getContent();

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(is);

            json = JSON.encode(doc);
        } catch (ParserConfigurationException e) {
            e.printStackTrace(); // TODO
        } catch (SAXException e) {
            e.printStackTrace(); // TODO
        } finally {
            client.close();
        }

        Log.i("", json);
        return new WeatherForecast(new JSONObject(json));
    }
}