package com.my.bharatsamachar.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.VideoView;

import com.my.bharatsamachar.R;

public class SplashScreen extends AppCompatActivity {

   // public  static int SPLASH_TIME_OUT =  5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

       /* getSupportActionBar().hide();
        VideoView view = (VideoView)findViewById(R.id.vv);
        String path = "android.resource://" + getPackageName() + "/" + R.raw.bharat;
        view.setVideoURI(Uri.parse(path));
        view.start();*/

    }

}