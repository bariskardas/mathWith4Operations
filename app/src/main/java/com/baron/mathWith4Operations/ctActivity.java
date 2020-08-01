package com.baron.mathWith4Operations;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ctActivity extends AppCompatActivity implements  View.OnClickListener{
    Button geritus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ct);
        geritus = (Button) findViewById(R.id.btngeritus);
        geritus.setOnClickListener(this);



        //Yazı Tipi Degistirme Yöntemi
        TextView txtbaslik = (TextView) findViewById(R.id.txtbaslik);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/CaveatBrush-Regular.ttf");
        txtbaslik.setTypeface(typeface);
        //

    }

    public void onClick(View v) {
        try{

            switch (v.getId()) {
                case R.id.btngeritus:
                    Intent d = new Intent(ctActivity.this, MainActivity.class);
                    startActivity(d);
                    overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                    break;

            }

        }
        catch(NumberFormatException ex){ // handle your exception
            ex.printStackTrace();
        }

    }


    @Override
    public void onBackPressed() {


        Intent d = new Intent(ctActivity.this, MainActivity.class);
        startActivity(d);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        finish();

    }

}
