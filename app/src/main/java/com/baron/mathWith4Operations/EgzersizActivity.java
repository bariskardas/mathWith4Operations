package com.baron.mathWith4Operations;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class EgzersizActivity extends AppCompatActivity  implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_egzersiz);

        RelativeLayout layout = findViewById(R.id.layout);
        AnimationDrawable animationDrawable = (AnimationDrawable)  layout.getBackground();
        animationDrawable.setEnterFadeDuration(1000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();

        TextView txtbaslik = (TextView) findViewById(R.id.txtbaslik);
        final Button carpim = (Button) findViewById(R.id.btnCarpimtablosu);
        final Button dortislem = (Button) findViewById(R.id.btndortislem);
        final Button dogruyanlis = (Button) findViewById(R.id.btnDogruYanlis);
        final Button ikioyunculu = (Button) findViewById(R.id.btnikioyunculu);

        ikioyunculu.setOnClickListener(this);

        // banner reklam ekleme
        AdView bottombanner = findViewById(R.id.bottombanner);
        //noinspection deprecation
        MobileAds.initialize(this,"ca-app-pub-6491185507594357~7814704476");
        AdRequest adRequest = new AdRequest.Builder().build();
        bottombanner.loadAd(adRequest);





        //Yazı Tipi Degistirme Yöntemi
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/CaveatBrush-Regular.ttf");
        txtbaslik.setTypeface(typeface);
        carpim.setTypeface(typeface);
        dortislem.setTypeface(typeface);
        dogruyanlis.setTypeface(typeface);
        ikioyunculu.setTypeface(typeface);
        //

        Animation fromleft300 = AnimationUtils.loadAnimation(this,R.anim.fromleft300);
        Animation fromleft500 = AnimationUtils.loadAnimation(this,R.anim.fromleft500);
        Animation fromleft700 = AnimationUtils.loadAnimation(this,R.anim.fromleft700);
        Animation fromleft900 = AnimationUtils.loadAnimation(this,R.anim.fromleft900);

        carpim.setAnimation(fromleft300);
        dortislem.setAnimation(fromleft500);
        dogruyanlis.setAnimation(fromleft700);
        ikioyunculu.setAnimation(fromleft900);


         final Animation scaleup = AnimationUtils.loadAnimation(this, R.anim.scale_up);
         final Animation scaledown = AnimationUtils.loadAnimation(this, R.anim.scale_down);



        carpim.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()== MotionEvent.ACTION_DOWN){
                    carpim.startAnimation(scaleup);
                }
                else if(event.getAction()== MotionEvent.ACTION_UP){
                    carpim.startAnimation(scaledown);
                }

                return false;
            }
        });


        dortislem.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()== MotionEvent.ACTION_DOWN){
                    dortislem.startAnimation(scaleup);
                }
                else if(event.getAction()== MotionEvent.ACTION_UP){
                    dortislem.startAnimation(scaledown);
                }

                return false;
            }
        });

        dogruyanlis.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()== MotionEvent.ACTION_DOWN){
                    dogruyanlis.startAnimation(scaleup);
                }
                else if(event.getAction()== MotionEvent.ACTION_UP){
                    dogruyanlis.startAnimation(scaledown);
                }

                return false;
            }
        });


        ikioyunculu.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()== MotionEvent.ACTION_DOWN){
                    ikioyunculu.startAnimation(scaleup);
                }
                else if(event.getAction()== MotionEvent.ACTION_UP){
                    ikioyunculu.startAnimation(scaledown);
                }

                return false;
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btngeritus:
                Intent d = new Intent(EgzersizActivity.this, MainActivity.class);
                startActivity(d);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                break;
            case R.id.btnCarpimtablosu:
                Intent a = new Intent(EgzersizActivity.this, CTEgzersizActivity.class);
                startActivity(a);
                break;

            case R.id.btndortislem:
                Intent b = new Intent(EgzersizActivity.this, DortislemActivity.class);
                startActivity(b);
                break;

            case R.id.btnDogruYanlis:
                Intent c = new Intent(EgzersizActivity.this, DogruYanlisActivity.class);
                startActivity(c);
                break;

            case R.id.btnikioyunculu:
                Intent e = new Intent(EgzersizActivity.this, ikioyunculuActivity.class);
                startActivity(e);
                break;


        }
    }

    @Override
    public void onBackPressed() {
        Intent x = new Intent(EgzersizActivity.this, MainActivity.class);
        startActivity(x);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }


}
