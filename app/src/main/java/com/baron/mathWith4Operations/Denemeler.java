package com.baron.mathWith4Operations;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;
import java.util.Random;

public class Denemeler extends AppCompatActivity implements View.OnClickListener  {
    private static final long START_TIME_IN_MILLIS = 61000;
    private CountDownTimer countDownTimer;
    private boolean mTimerRunning;
    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;

    Button cevapla, geritus,btndogru,btnyanlis;
    EditText sonuc;
    TextView sayi1, sayi2, dsayisi, ysayisi, zaman;
    int dsayac = 0, ysayac = 0, sonucc, cevap;
    int sayi_1, sayi_2, dogru, yanlis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_denemeler);

        zaman = (TextView) findViewById(R.id.txtzaman);
        dsayisi = (TextView) findViewById(R.id.txtdsayisi);
        ysayisi = (TextView) findViewById(R.id.txtysayisi);
        sayi1 = (TextView) findViewById(R.id.txtSayi1);
        btndogru = (Button) findViewById(R.id.btndogru);
        btnyanlis = (Button) findViewById(R.id.btnyanlis);
        geritus = (Button) findViewById(R.id.btngeritus2);

        //zaman.setOnClickListener(this);
        dsayisi.setOnClickListener(this);
        ysayisi.setOnClickListener(this);
        sayi1.setOnClickListener(this);
        sayi2.setOnClickListener(this);
        sonuc.setOnClickListener(this);
        cevapla.setOnClickListener(this);
        geritus.setOnClickListener(this);


        //sayi1.setText(rastgelesayi + "");



        countDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
                updateCountDownText();

                //zaman.setText(""+millisUntilFinished/1000);
            }


            @Override
            public void onFinish() {
                mTimerRunning = false;
                //Intent intent = new Intent(getApplicationContext(), CbSonucActivity.class);
                dogru = Integer.parseInt(dsayisi.getText().toString());
                yanlis = Integer.parseInt(ysayisi.getText().toString());
                //intent.putExtra("ds", dogru);
                //intent.putExtra("ys", yanlis);
                //startActivity(intent);

            }
        }.start();

        //mTimerRunning = true;


    }

    private void updateCountDownText() {
        int minutes = (int) (mTimeLeftInMillis / 1000) / 60;
        int seconds = (int) (mTimeLeftInMillis / 1000) % 60;

        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
        zaman.setText(timeLeftFormatted);
    }


    @Override
    public void onClick(View v) {
        try {


            switch (v.getId()) {
                case R.id.btndogru:
                    /* TANIMLAR */
                    final long a = 900;
                    final MediaPlayer[] ply = new MediaPlayer[1];
                    //

                    sayi_1 = Integer.parseInt(sayi1.getText().toString());
                    sayi_2 = Integer.parseInt(sayi2.getText().toString());
                    cevap = sayi_1 * sayi_2;
                    sonucc = Integer.parseInt(sonuc.getText().toString());

                    if (sonucc == cevap) {
                        ++dsayac;

                       /* CountDownTimer countDownTimer2 = new CountDownTimer(a, 1000) {
                            @Override
                            public void onTick(long millisUntilFinished) {

                                ply[0] = MediaPlayer.create(DogruYanlisActivity.this, R.raw.ses1);
                                ply[0].start();
                            }

                            @Override
                            public void onFinish() {

                            }
                        }.start();
*/
                    } else {
                        ++ysayac;

                     /*   CountDownTimer countDownTimer2 = new CountDownTimer(a, 1000) {
                            @Override
                            public void onTick(long millisUntilFinished) {
                                ply[0] = MediaPlayer.create(DogruYanlisActivity.this, R.raw.ses2);
                                ply[0].start();

                            }
                            @Override
                            public void onFinish() {

                            }
                        }.start();
                    */}

                    Random rastgelesayiOlusturucu = new Random();
                    int rastgelesayi = rastgelesayiOlusturucu.nextInt(11); // 0-9 du +1 geldi yeni hali 1-10 geliyor
                    sayi1.setText(rastgelesayi + "");

                    Random rastgelesayiOlusturucu2 = new Random();
                    int rastgelesayi2 = rastgelesayiOlusturucu.nextInt(11);
                    sayi2.setText(rastgelesayi2 + "");

                    dsayisi.setText("" + dsayac);
                    ysayisi.setText("" + ysayac);
                    sonuc.setText("");

                    break;

                case R.id.btngeritus2:
                    countDownTimer.cancel();
                    Intent d = new Intent(Denemeler.this, EgzersizActivity.class);
                    startActivity(d);
                    overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                    break;

            }


        } catch (NumberFormatException ex) { // handle your exception
            ex.printStackTrace();
        }

    }

    @Override
    public void onBackPressed() {


        if (countDownTimer != null) {
            countDownTimer.cancel();
            countDownTimer = null;
        }
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        finish();

    }

}