package com.baron.mathWith4Operations;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class K2Activity extends AppCompatActivity implements View.OnClickListener{
    Button geridon;
    private InterstitialAd mInterstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_k1);

        geridon = (Button) findViewById(R.id.btngeridon);
        geridon.setOnClickListener(this);

        // Tam ekran reklam
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-6491185507594357/8027894251");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());


    }

    @Override
    public void onClick(View v) {
        try{


            switch (v.getId()) {
                case R.id.btngeridon:
                    goster();
                    break;

            }


        }
        catch(NumberFormatException ex){ // handle your exception
            ex.printStackTrace();
        }

    }

    public void goster() {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
            mInterstitialAd.setAdListener(new AdListener(){

                @Override
                public void onAdLoaded() {
                    mInterstitialAd.show();
                    super.onAdLoaded();
                }

                @Override
                public void onAdClosed() {
                    super.onAdClosed();
                    Intent f = new Intent(K2Activity.this, EgzersizActivity.class);
                    startActivity(f);
                }
            });
        } else {
            Log.d("TAG", "The interstitial wasn't loaded yet.");
            Intent f = new Intent(K2Activity.this, EgzersizActivity.class);
            startActivity(f);

        }
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setMessage("Çıkış Yapmak istiyor musunuz?");

        builder.setPositiveButton("EVET", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Evet'e basılınca yapılacak işlemleri yazınız
                Intent a = new Intent(K2Activity.this, EgzersizActivity.class);
                startActivity(a);

            }
        });

        builder.setNegativeButton("HAYIR", new DialogInterface.OnClickListener() {
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
