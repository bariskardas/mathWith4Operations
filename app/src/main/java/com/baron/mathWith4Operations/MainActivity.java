package com.baron.mathWith4Operations;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.ads.MobileAds;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView txtbaslik;
    Button carpim, dy, egzersiz, oyver;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtbaslik = (TextView) findViewById(R.id.txtbaslik);
        carpim = (Button) findViewById(R.id.btnCarpimtablosu);
        egzersiz = (Button) findViewById(R.id.btnEgzersizYap);
        oyver = (Button) findViewById(R.id.btnoyver);

        oyver.setOnClickListener(this);

        // banner reklam ekleme

        AdView bottombanner = findViewById(R.id.bottombanner);
        //noinspection deprecation
        MobileAds.initialize(this, "ca-app-pub-6491185507594357~7814704476");
        AdRequest adRequest = new AdRequest.Builder().build();
        bottombanner.loadAd(adRequest);


        // animasyon kısmı
        RelativeLayout layout = findViewById(R.id.layout);
        AnimationDrawable animationDrawable = (AnimationDrawable) layout.getBackground();
        animationDrawable.setEnterFadeDuration(1000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();


        //baslik yazı tipi degistirme
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/CaveatBrush-Regular.ttf");
        txtbaslik.setTypeface(typeface);
        carpim.setTypeface(typeface);
        egzersiz.setTypeface(typeface);
        oyver.setTypeface(typeface);

        //

        // buton animasyon geçişleri
        Animation fromleft300 = AnimationUtils.loadAnimation(this, R.anim.fromleft300);
        Animation fromleft500 = AnimationUtils.loadAnimation(this, R.anim.fromleft500);
        Animation fromleft700 = AnimationUtils.loadAnimation(this, R.anim.fromleft700);
        final Animation scaleup = AnimationUtils.loadAnimation(this, R.anim.scale_up);
        final Animation scaledown = AnimationUtils.loadAnimation(this, R.anim.scale_down);
        carpim.setAnimation(fromleft300);
        egzersiz.setAnimation(fromleft500);
        oyver.setAnimation(fromleft700);
        //

        carpim.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    carpim.startAnimation(scaleup);
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    carpim.startAnimation(scaledown);
                }

                return false;
            }
        });


        egzersiz.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    egzersiz.startAnimation(scaleup);
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    egzersiz.startAnimation(scaledown);
                }

                return false;
            }
        });

        oyver.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    oyver.startAnimation(scaleup);
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    oyver.startAnimation(scaledown);
                }

                return false;
            }
        });

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnCarpimtablosu:
                Intent a = new Intent(MainActivity.this, ctActivity.class);
                startActivity(a);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;

            case R.id.btnEgzersizYap:
                Intent b = new Intent(MainActivity.this, EgzersizActivity.class);
                startActivity(b);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;

            case R.id.btnoyver:
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.baron.mathWith4Operations"));
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setMessage(getResources().getString(R.string.cikis_bilgi));

        builder.setPositiveButton(getResources().getString(R.string.evet), new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Evet'e basılınca yapılacak işlemleri yazınız
                finish();
                ActivityCompat.finishAffinity(MainActivity.this);
            }
        });

        builder.setNegativeButton(getResources().getString(R.string.hayır), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Hayır'a baslınca yapılacak işmeleri yazınız
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
