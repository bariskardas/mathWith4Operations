package com.baron.mathWith4Operations;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.Locale;

public class CtSonucActivity extends AppCompatActivity implements View.OnClickListener{
    TextView d,y,puan,net;
    int dpuan,ypuan,toplam_puan;
    Button geridon;
    private InterstitialAd mInterstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ct_sonuc);

        d = (TextView) findViewById(R.id.txtdsayisi_2);
        y = (TextView) findViewById(R.id.txtysayisi_2);
        puan = (TextView) findViewById(R.id.txtpuan);
        net = (TextView) findViewById(R.id.txtnet);
        geridon = (Button) findViewById(R.id.btngeridon);

       geridon.setOnClickListener(this);



        Intent intent =getIntent();
        int ds =intent.getIntExtra("ds",-1);
        int ys = intent.getIntExtra("ys",-1);

        d.setText(""+ds);
        y.setText(""+ys);

        int toplam_puan = (4*ds) + ((-1)*ys) ;
        puan.setText(""+toplam_puan);
        float net_puan = (float)(toplam_puan) / 10;
        String yeni = String.format(Locale.getDefault(),"%.1f",net_puan);
        net.setText(""+yeni);

    }

    @Override
    public void onClick(View v) {
        try{


            switch (v.getId()) {
                case R.id.btngeridon:
                    intitialreklamgoster();
                    Intent a = new Intent(CtSonucActivity.this, EgzersizActivity.class);
                    startActivity(a);

            }


        }
        catch(NumberFormatException ex){ // handle your exception
            ex.printStackTrace();
        }

    }

    public void intitialreklamgoster() {
        //InterstitialAd tam ekran reklam
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {}
        });
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-6491185507594357/8027894251");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        mInterstitialAd.setAdListener(new AdListener(){

            @Override
            public void onAdLoaded() {
                mInterstitialAd.show();
                super.onAdLoaded();
            }

            @Override
            public void onAdClosed() {
                super.onAdClosed();
                Intent f = new Intent(CtSonucActivity.this, EgzersizActivity.class);
                startActivity(f);
            }
        });
    }
}
