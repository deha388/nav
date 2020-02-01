package com.demo1.nav.Workout.Split.Beginner;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;


import com.demo1.nav.Main.Home;
import com.demo1.nav.R;



public class Splash extends Activity {
    private static int SPLASH_TIME_OUT = 3000;



    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {



            @Override
            public void run() {

                Intent i = new Intent(Splash.this, Home.class);
                startActivity(i);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
