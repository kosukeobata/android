package com.example.kosukeobata.helloandroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.widget.SeekBar;


public class MyActivity extends Activity implements SeekBar.OnSeekBarChangeListener{

    private Button buttonPushMe;
    private ImageView imageAndroid;

    private SeekBar seekBarRed;
    private SeekBar seekBarBlue;
    private SeekBar seekBarGreen;

    private Button buttonUpCounter;
    private Button buttonDownCounter;
    private int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        counter = 0;

        buttonUpCounter = (Button) findViewById(R.id.btn_countup);
        buttonUpCounter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                buttonUpCounter.setText("Count: " + counter);
            }
        });

        buttonDownCounter = (Button) findViewById(R.id.btn_countdown);
        buttonDownCounter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter--;
                buttonUpCounter.setText("Count: " + counter);
            }
        });

        buttonPushMe = (Button) findViewById(R.id.btn_pushme);
        buttonPushMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonPushMe.setText("pushed!!");
                imageAndroid.setImageResource(R.mipmap.katsuo);
            }
        });
        imageAndroid = (ImageView) findViewById(R.id.iv_android);

        seekBarRed = (SeekBar) findViewById(R.id.sb_red);
        seekBarRed.setOnSeekBarChangeListener(this);

        seekBarGreen = (SeekBar) findViewById(R.id.sb_green);
        seekBarGreen.setOnSeekBarChangeListener(this);

        seekBarBlue = (SeekBar) findViewById(R.id.sb_blue);
        seekBarBlue.setOnSeekBarChangeListener(this);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        int red = seekBarRed.getProgress();
        int green = seekBarGreen.getProgress();
        int blue = seekBarBlue.getProgress();
        imageAndroid.setColorFilter(Color.rgb(red, green, blue), PorterDuff.Mode.LIGHTEN);
    }

    @Override
    public void onStartTrackingTouch (SeekBar seekBar) {
    }

    @Override
    public void onStopTrackingTouch (SeekBar seekBar) {
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
