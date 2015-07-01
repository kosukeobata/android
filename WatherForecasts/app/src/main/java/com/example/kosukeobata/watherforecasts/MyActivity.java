package com.example.kosukeobata.watherforecasts;

<<<<<<< HEAD
import android.app.Activity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MyActivity extends Activity {
    private TextView location;
    private LinearLayout forecastLayout;
    private ProgressBar progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        location = (TextView) findViewById(R.id.tv_location);
        forecastLayout = (LinearLayout) findViewById(R.id.ll_forecasts);
        progress = (ProgressBar) findViewById(R.id.progress);

        new GetWeatherForecastTask(this).execute("400040");
    }

    private class GetWeatherForecastTask extends GetWeatherForecastApiTask {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progress.setVisibility(View.VISIBLE);
        }

        public GetWeatherForecastTask(Context context) {
            super(context);
        }

        @Override
        protected void onPostExecute(WeatherForecast data) {
            super.onPostExecute(data);

            progress.setVisibility(View.GONE);

            if (data != null) {
                location.setText(data.location.area + " " +
                        data.location.prefecture + " " + data.location.city);

                //予報を一覧表示
                for (WeatherForecast.Forecast forecast : data.forecastList) {
                    View row = View.inflate(MyActivity.this, R.layout.forecasts_row, null);

                    TextView date = (TextView) row.findViewById(R.id.tv_date);
                    date.setText(forecast.dateLabel);

                    TextView telop = (TextView) row.findViewById(R.id.tv_telop);
                    telop.setText(forecast.telop);

                    TextView temp = (TextView) row.findViewById(R.id.tv_tempreture);
                    temp.setText(forecast.temperature.toString());

                    ImageView imageView = (ImageView) row.findViewById(R.id.iv_weather);
                    imageView.setTag(forecast.image.url); //読み込むURを設定

                    //読み込み処理の実行
                    ImageLoaderTask task = new ImageLoaderTask(MyActivity.this);
                    task.execute(imageView);

                    forecastLayout.addView(row);
                }
            } else if (exception != null) {
                Toast.makeText(MyActivity.this, exception.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }


=======
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.json.JSONArray;
import org.w3c.dom.Document;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyActivity extends ActionBarActivity {

    private static final String[] POINT_LIST = {
            "270000",
            "130010",
            "040010"};

    private List<String> pointList;

    private Adapter adapter;
    private ViewPager viewPager;

    private class Adapter extends FragmentStatePagerAdapter {

        public Adapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return FragmentWeather.newInstance(pointList.get(position));
        }

        @Override
        public int getCount() {
            return pointList.size();
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        if (pointList == null) {
            pointList = Arrays.asList(POINT_LIST);

        }

        viewPager = (ViewPager) findViewById(R.id.vp_main);
        adapter = new Adapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
    }
}
>>>>>>> 90e3125dfeaaaad3c8f2dd967bff58a9d4fde4b0

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_my, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
<<<<<<< HEAD
}
=======
>>>>>>> 90e3125dfeaaaad3c8f2dd967bff58a9d4fde4b0
