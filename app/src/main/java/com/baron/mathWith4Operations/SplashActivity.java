package com.baron.mathWith4Operations;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread logoAnimation = new Thread(){
            @Override
            public void run(){
                ImageView logo = findViewById(R.id.picture);

                Animation a = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fromtop);
                logo.startAnimation(a);

            }
        };
        logoAnimation.start();


        Thread authorAnimation = new Thread(){
            @Override
            public void run(){
                TextView logo = findViewById(R.id.yazar);
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.frombottom);
                logo.startAnimation(animation);
            }
        };
        authorAnimation.start();


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent s = new Intent(SplashActivity.this,MainActivity.class);
                startActivity(s);
                finish();
            }
        },SPLASH_TIME_OUT);






    }
}
