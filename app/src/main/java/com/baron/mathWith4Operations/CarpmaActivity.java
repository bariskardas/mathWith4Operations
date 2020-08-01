package com.baron.mathWith4Operations;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

import java.util.Locale;
import java.util.Random;


public class CarpmaActivity extends AppCompatActivity implements View.OnClickListener {
    private static final long START_TIME_IN_MILLIS = 121000;
    private CountDownTimer countDownTimer;
    private boolean mTimerRunning;
    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;

    Button cevapla, geritus;
    EditText sonuc;
    TextView sayi1, sayi2, dsayisi, ysayisi, zaman;
    int dsayac = 0, ysayac = 0, sonucc, cevap;
    int sayi_1, sayi_2, dogru, yanlis;
    Random rnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carpma);

        zaman = (TextView) findViewById(R.id.txtzaman);
        dsayisi = (TextView) findViewById(R.id.txtdsayisi);
        ysayisi = (TextView) findViewById(R.id.txtysayisi);
        sayi1 = (TextView) findViewById(R.id.txtSayi1);
        sayi2 = (TextView) findViewById(R.id.txtSayi2);
        sonuc = (EditText) findViewById(R.id.etSonuc);
        cevapla = (Button) findViewById(R.id.btnCevapla);
        geritus = (Button) findViewById(R.id.btngeritus2);

        //zaman.setOnClickListener(this);
        dsayisi.setOnClickListener(this);
        ysayisi.setOnClickListener(this);
        sayi1.setOnClickListener(this);
        sayi2.setOnClickListener(this);
        sonuc.setOnClickListener(this);
        cevapla.setOnClickListener(this);
        geritus.setOnClickListener(this);

        rnd = new Random();
        int rastgelesayi = rnd.nextInt(50) + 1;
        int rastgelesayi2 = rnd.nextInt(10) + 1;
        sayi1.setText(rastgelesayi + "");
        sayi2.setText(rastgelesayi2 + "");


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
                Intent intent = new Intent(CarpmaActivity.this, CtSonucActivity.class);
                dogru = Integer.parseInt(dsayisi.getText().toString());
                yanlis = Integer.parseInt(ysayisi.getText().toString());
                intent.putExtra("ds", dogru);
                intent.putExtra("ys", yanlis);
                startActivity(intent);

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

    @SuppressLint("ResourceAsColor")
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)

    @Override
    public void onClick(View v) {
        try {
            switch (v.getId()) {
                case R.id.btnCevapla:
                    /* TANIMLAR */
                    final LinearLayout linearLayout = findViewById(R.id.layout);
                    final LottieAnimationView animation1 = (LottieAnimationView) findViewById(R.id.animations);
                    final LottieAnimationView animation2 = (LottieAnimationView) findViewById(R.id.animations2);
                    final long a = 900;
                    final MediaPlayer[] ply = new MediaPlayer[1];
                    //

                    sayi_1 = Integer.parseInt(sayi1.getText().toString());
                    sayi_2 = Integer.parseInt(sayi2.getText().toString());
                    cevap = sayi_1 * sayi_2;
                    sonucc = Integer.parseInt(sonuc.getText().toString());

                    if (sonucc == cevap) {
                        ++dsayac;
                        linearLayout.setBackgroundColor(getResources().getColor(R.color.green));
                        cevapla.setBackground(getResources().getDrawable(R.drawable.ripple_green));

                        CountDownTimer countDownTimer2 = new CountDownTimer(a, 1000) {
                            @Override
                            public void onTick(long millisUntilFinished) {

                                ply[0] = MediaPlayer.create(CarpmaActivity.this, R.raw.ses1);
                                ply[0].start();
                                animation1.setVisibility(View.VISIBLE);
                                animation1.playAnimation();
                                animation1.setSpeed(4f);
                            }

                            @Override
                            public void onFinish() {
                                animation1.setVisibility(View.GONE);
                                animation1.cancelAnimation();
                                linearLayout.setBackgroundColor(getResources().getColor(R.color.lightpurple));
                                cevapla.setBackground(getResources().getDrawable(R.drawable.ripple_darkblue));
                            }
                        }.start();

                    } else {
                        ++ysayac;
                        linearLayout.setBackground(getResources().getDrawable(R.color.red));
                        cevapla.setBackground(getResources().getDrawable(R.drawable.ripple_red));

                        CountDownTimer countDownTimer2 = new CountDownTimer(a, 1000) {
                            @Override
                            public void onTick(long millisUntilFinished) {
                                ply[0] = MediaPlayer.create(CarpmaActivity.this, R.raw.ses2);
                                ply[0].start();
                                animation2.setVisibility(View.VISIBLE);
                                animation2.playAnimation();
                                animation2.setSpeed(4f);
                            }

                            @Override
                            public void onFinish() {
                                animation2.setVisibility(View.GONE);
                                animation2.cancelAnimation();
                                linearLayout.setBackground(getResources().getDrawable(R.color.lightpurple));
                                cevapla.setBackground(getResources().getDrawable(R.drawable.ripple_darkblue));

                            }
                        }.start();
                    }

                    newNumber();

                    break;

                case R.id.btngeritus2:
                    countDownTimer.cancel();
                    Intent d = new Intent(CarpmaActivity.this, DortislemActivity.class);
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
        Intent d = new Intent(CarpmaActivity.this, DortislemActivity.class);
        startActivity(d);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        finish();

    }

    public void newNumber() {
        rnd = new Random();
        int rastgelesayi = rnd.nextInt(50) + 1;
        sayi1.setText(rastgelesayi + "");
        int rastgelesayi2 = rnd.nextInt(10) + 1;
        sayi2.setText(rastgelesayi2 + "");

        dsayisi.setText("" + dsayac);
        ysayisi.setText("" + ysayac);
        sonuc.setText("");
    }
}

