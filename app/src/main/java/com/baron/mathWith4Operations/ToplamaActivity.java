package com.baron.mathWith4Operations;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
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

public class ToplamaActivity extends AppCompatActivity implements View.OnClickListener {
    private static final long START_TIME_IN_MILLIS= 121000;
    private CountDownTimer countDownTimer;
    private boolean mTimerRunning;
    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;

    Button cevapla,geritus;
    EditText sonuc;
    TextView sayi1,sayi2,dsayisi,ysayisi,zaman;
    int dsayac = 0 ,ysayac = 0,sonucc,cevap;
    int sayi_1,sayi_2,dogru,yanlis;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toplama);


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

        Random rastgelesayiOlusturucu = new Random();
        int rastgelesayi = rastgelesayiOlusturucu.nextInt(101);
        Random rastgelesayiOlusturucu2 = new Random();
        int rastgelesayi2 = rastgelesayiOlusturucu2.nextInt(101);
        sayi1.setText(rastgelesayi+"");
        sayi2.setText(rastgelesayi2+"");


        countDownTimer = new CountDownTimer(mTimeLeftInMillis,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
                updateCountDownText();

                //zaman.setText(""+millisUntilFinished/1000);
            }


            @Override
            public void onFinish() {
                mTimerRunning = false;
                Intent intent = new Intent(ToplamaActivity.this,CtSonucActivity.class);
                dogru =Integer.parseInt(dsayisi.getText().toString());
                yanlis =Integer.parseInt(ysayisi.getText().toString());
                intent.putExtra("ds",dogru);
                intent.putExtra("ys",yanlis);
                startActivity(intent);

            }
        }.start();

        //mTimerRunning = true;


    }

    private void updateCountDownText(){
        int minutes = (int) (mTimeLeftInMillis/1000) / 60;
        int seconds = (int) (mTimeLeftInMillis/1000) % 60;

        String timeLeftFormatted = String.format(Locale.getDefault(),"%02d:%02d",minutes,seconds);
        zaman.setText(timeLeftFormatted);
    }


    @SuppressLint("ResourceAsColor")
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onClick(View v) {
        try{

            switch (v.getId()) {
                case R.id.btnCevapla:
                    /* TANIMLAR */
                    final LottieAnimationView animation1 = (LottieAnimationView) findViewById(R.id.animations);
                    final LottieAnimationView animation2 = (LottieAnimationView) findViewById(R.id.animations2);
                    final long a = 900;
                    final MediaPlayer[] ply = new MediaPlayer[1];
                    //
                    /* MATEMATİKSEL ISLEMLER  */
                    sayi_1=Integer.parseInt(sayi1.getText().toString());
                    sayi_2=Integer.parseInt(sayi2.getText().toString());
                    cevap = sayi_1 + sayi_2;
                    sonucc=Integer.parseInt(sonuc.getText().toString());
                    //

                    /*  IF KOSULU */
                    if (sonucc == cevap) {
                        ++dsayac;
                        final LinearLayout linearLayout = findViewById(R.id.layout);
                        linearLayout.setBackgroundColor(getResources().getColor(R.color.green));
                        cevapla.setBackground(getResources().getDrawable(R.drawable.ripple_green));

                        /* TOAST KULLANIMI
                        final Toast toast = new Toast(getApplicationContext());
                        */

                        CountDownTimer countDownTimer2 = new CountDownTimer(a,1000) {
                            @Override
                            public void onTick(long millisUntilFinished) {
                                /*
                               // TOAST KULLANIMI //
                                LayoutInflater inflater = getLayoutInflater();
                                View layout = inflater.inflate(R.layout.activity_toast,
                                        (ViewGroup) findViewById(R.id.toast_layout_root));

                                ImageView image = (ImageView) layout.findViewById(R.id.image);
                                image.setImageResource(R.drawable.geritus);


                                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                                toast.setDuration((int) a);
                                toast.setView(layout);
                                toast.show();
                            */
                                ply[0] = MediaPlayer.create(ToplamaActivity.this,R.raw.ses1);
                                ply[0].start();
                                animation1.setVisibility(View.VISIBLE);
                                animation1.playAnimation();
                                animation1.setSpeed(4f);
                            }

                            @Override
                            public void onFinish() {
                               /*TOAST KULLANIMI
                                toast.cancel();
                               */
                                animation1.setVisibility(View.GONE);
                               animation1.cancelAnimation();
                                cevapla.setBackground(getResources().getDrawable(R.drawable.ripple_darkblue));
                                linearLayout.setBackgroundColor(getResources().getColor(R.color.blue));
                            }
                        }.start();
                    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

                     else {
                        ++ysayac;
                        final LinearLayout linearLayout = findViewById(R.id.layout);
                        linearLayout.setBackgroundColor(Color.RED);
                        cevapla.setBackground(getResources().getDrawable(R.drawable.ripple_red));

                        CountDownTimer countDownTimer2 = new CountDownTimer(a,1000) {
                            @Override
                            public void onTick(long millisUntilFinished) {
                                ply[0] = MediaPlayer.create(ToplamaActivity.this,R.raw.ses2);
                                ply[0].start();
                                animation2.setVisibility(View.VISIBLE);
                                animation2.playAnimation();
                                animation2.setSpeed(4f);
                            }

                            @Override
                            public void onFinish() {
                                animation2.setVisibility(View.GONE);
                                animation2.cancelAnimation();
                                cevapla.setBackground(getResources().getDrawable(R.drawable.ripple_darkblue));
                                linearLayout.setBackgroundColor(getResources().getColor(R.color.blue));
                            }
                        }.start();
                    }

                    Random rastgelesayiOlusturucu = new Random();
                    int rastgelesayi = rastgelesayiOlusturucu.nextInt(100)+1;
                    sayi1.setText(rastgelesayi+"");

                    Random rastgelesayiOlusturucu2 = new Random();
                    int rastgelesayi2 = rastgelesayiOlusturucu2.nextInt(100)+1;
                    sayi2.setText(rastgelesayi2+"");

                    dsayisi.setText(""+dsayac);
                    ysayisi.setText(""+ysayac);
                    sonuc.setText("");

                    break;

                case R.id.btngeritus2:
                    countDownTimer.cancel();
                    Intent d = new Intent(ToplamaActivity.this, DortislemActivity.class);
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


        if (countDownTimer!=null) {
            countDownTimer.cancel();
            countDownTimer = null;
        }
        Intent d = new Intent(ToplamaActivity.this, DortislemActivity.class);
        startActivity(d);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        finish();

    }

}
