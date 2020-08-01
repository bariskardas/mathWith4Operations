package com.baron.mathWith4Operations;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class DortislemActivity extends AppCompatActivity  implements View.OnClickListener {

    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dortislem);

        // ARKA PLANI HAREKETLENDİRME ANİMASYONU
        RelativeLayout layout = findViewById(R.id.layout);
        AnimationDrawable animationDrawable = (AnimationDrawable)  layout.getBackground();
        animationDrawable.setEnterFadeDuration(1000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();

        TextView txtbaslik = (TextView) findViewById(R.id.txtbaslik);
        Button toplama = (Button) findViewById(R.id.btntoplama);
        Button cikarma = (Button) findViewById(R.id.btncikarma);
        Button carpma = (Button) findViewById(R.id.btncarpma);
        Button bolme = (Button) findViewById(R.id.btnbolme);
        Button karisik = (Button) findViewById(R.id.btnkarisik);


        // banner reklam ekleme
        AdView bottombanner = findViewById(R.id.bottombanner);
        //noinspection deprecation
        MobileAds.initialize(this,"ca-app-pub-6491185507594357~7814704476");
        AdRequest adRequest = new AdRequest.Builder().build();
        bottombanner.loadAd(adRequest);

        // Tam ekran reklam
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-6491185507594357/8027894251");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());






        //Yazı Tipi Degistirme Yöntemi
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/CaveatBrush-Regular.ttf");
        txtbaslik.setTypeface(typeface);
        toplama.setTypeface(typeface);
        cikarma.setTypeface(typeface);
        carpma.setTypeface(typeface);
        bolme.setTypeface(typeface);
        karisik.setTypeface(typeface);
        //

        Animation frombottom800 = AnimationUtils.loadAnimation(this,R.anim.frombottom800);
        toplama.setAnimation(frombottom800);
        cikarma.setAnimation(frombottom800);
        carpma.setAnimation(frombottom800);
        bolme.setAnimation(frombottom800);
        karisik.setAnimation(frombottom800);
    }


    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btngeritus:
                Intent a = new Intent(DortislemActivity.this, EgzersizActivity.class);
                startActivity(a);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                break;
            case R.id.btntoplama:
                Intent b = new Intent(DortislemActivity.this, ToplamaActivity.class);
                startActivity(b);
                break;

            case R.id.btncikarma:
                Intent c = new Intent(DortislemActivity.this, CikarmaActivity.class);
                startActivity(c);
                break;

            case R.id.btncarpma:
                Intent d = new Intent(DortislemActivity.this, CarpmaActivity.class);
                startActivity(d);
                break;

            case R.id.btnbolme:
                Intent e = new Intent(DortislemActivity.this, BolmeActivity.class);
                startActivity(e);
                break;

            case R.id.btnkarisik:
                    karisikgoster();
                break;


        }
    }

    public void karisikgoster() {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Log.d("TAG", "The interstitial wasn't loaded yet.");
            Intent f = new Intent(DortislemActivity.this, KarisikActivity.class);
            startActivity(f);

        }
    }

    @Override
    public void onBackPressed() {
        Intent x = new Intent(DortislemActivity.this, EgzersizActivity.class);
        startActivity(x);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }


}
