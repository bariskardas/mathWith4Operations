package com.baron.mathWith4Operations;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class DogruYanlisActivity extends AppCompatActivity implements View.OnClickListener {
    private static final long START_TIME_IN_MILLIS = 61000;
    private CountDownTimer countDownTimer;
    private boolean mTimerRunning;
    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;
    Button cevapla, geritus, btndogru, btnyanlis;
    TextView sonuc;
    TextView sayi1, sayi2, dsayisi, ysayisi, zaman;
    int dsayac = 0, ysayac = 0, sonucc, cevap;
    int sayi_1, sayi_2, dogru, yanlis;
    public ArrayList<String> word;
    public ArrayList<String> word2;
    public int index;

    String wordOne = "";
    String wordTwo = "";

    Random rnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dogru_yanlis);

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
        geritus.setOnClickListener(this);
        btndogru.setOnClickListener(this);
        btnyanlis.setOnClickListener(this);


        word = new ArrayList<String>();
        word.add("1 x 2 = 1");
        word.add("2 x 1 = 2");
        word.add("3 x 7 = 23");
        word.add("4 x 3 = 12");
        word.add("5 x 8 = 46");
        word.add("6 x 4 = 24");
        word.add("7 x 0 = 7");
        word.add("10 x 1 = 10");
        word.add("13 x 2 = 29");
        word.add("13 x 2 = 26");
        word.add("5 x 6 = 35");
        word.add("7 x 6 = 47");
        word.add("2 x 3 = 6");
        word.add("2 x 15 = 35");
        word.add("3 x 15 = 45");
        word.add("4 x 15 = 60");
        word.add("1 + 2 = 2");
        word.add("2 + 1 = 3");
        word.add("16 + 16 = 22");
        word.add("15 + 14 = 29");
        word.add("25 + 12 = 47");
        word.add("12 + 26 = 48");
        word.add("2 / 1 = 1");
        word.add("36 / 3 = 12");
        word.add("48 / 12 = 6");
        word.add("39 / 3 = 13");
        word.add("56 / 7 = 9");
        word.add("72 / 9 = 8");
        word.add("9 / 3 = 3");
        word.add("18 / 3 = 9");
        word.add("27 / 9 = 3");
        word.add("12 / 4 = 4");
        word.add("34 / 2 = 18");
        word.add("36 / 4 = 9");
        word.add("12 / 4 = 3");
        word.add("72 - 9 = 64");
        word.add("15 - 7 = 8");
        word.add("39 - 17 = 12");
        word.add("34 - 17 = 17");
        word.add("47 - 12 = 34");
        word.add("52 - 13 = 39");

        newNumber();

        word2 = new ArrayList<String>();
        word2.add("1 x 2 = 2");
        word2.add("2 x 1 = 2");
        word2.add("3 x 7 = 21");
        word2.add("4 x 3 = 12");
        word2.add("5 x 8 = 40");
        word2.add("6 x 4 = 24");
        word2.add("7 x 0 = 0");
        word2.add("10 x 1 = 10");
        word2.add("13 x 2 = 26");
        word2.add("13 x 2 = 26");
        word2.add("5 x 6 = 30");
        word2.add("7 x 6 = 42");
        word2.add("2 x 3 = 6");
        word2.add("2 x 15 = 30");
        word2.add("3 x 15 = 30");
        word2.add("4 x 15 = 60");
        word2.add("1 + 2 = 3");
        word2.add("2 + 1 = 3");
        word2.add("16 + 16 = 32");
        word2.add("15 + 14 = 29");
        word2.add("25 + 12 = 37");
        word2.add("12 + 26 = 38");
        word2.add("2 / 1 = 2");
        word2.add("36 / 3 = 12");
        word2.add("48 / 12 = 4");
        word2.add("39 / 3 = 13");
        word2.add("56 / 7 = 8");
        word2.add("72 / 9 = 8");
        word2.add("9 / 3 = 3");
        word2.add("18 / 3 = 6");
        word2.add("27 / 9 = 3");
        word2.add("12 / 4 = 3");
        word2.add("34 / 2 = 17");
        word2.add("36 / 4 = 9");
        word2.add("12 / 4 = 3");
        word2.add("72 - 9 = 63");
        word2.add("15 - 7 = 8");
        word2.add("39 - 17 = 22");
        word2.add("34 - 17 = 17");
        word2.add("47 - 13 = 34");
        word2.add("52 - 13 = 39");



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
                Intent intent = new Intent(getApplicationContext(), CtSonucActivity.class);
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


    @Override
    public void onClick(View v) {
        System.out.println("onclick" + index); //index te hata olmasın ? index bi dk benim kodlar bakım gelyom tmdır burda mısın kapayım mikrofonu ayarlıyım istersen
        try {
            final long a = 900;
            final MediaPlayer[] ply = new MediaPlayer[1];
            wordOne = word.get(index).toString(); // bunların indexin altına alalım daha iyi
            wordTwo = word2.get(index).toString(); //bi dk ben word 2 nin üstüne mi almıstım çalışması lazımdı üstüneyse hata verir
            switch (v.getId()) { // btndogru ve btnyanlis yazıyor zaten bak
                case R.id.btndogru:
                    if (wordOne.equals(wordTwo)) {
                        ++dsayac;
                        CountDownTimer countDownTimer2 = new CountDownTimer(a, 1000) {
                            @Override
                            public void onTick(long millisUntilFinished) {

                                ply[0] = MediaPlayer.create(DogruYanlisActivity.this, R.raw.ses1);
                                ply[0].start();
                            }

                            @Override
                            public void onFinish() {

                            }
                        }.start();

                    } else {
                        ysayac++;

                        CountDownTimer countDownTimer2 = new CountDownTimer(a, 1000) {
                            @Override
                            public void onTick(long millisUntilFinished) {

                                ply[0] = MediaPlayer.create(DogruYanlisActivity.this, R.raw.ses2);
                                ply[0].start();
                            }

                            @Override
                            public void onFinish() {

                            }
                        }.start();
                    }
                    dsayisi.setText("" + dsayac); //doğruyu arttırdı yanlışa basınca doğru saydı orda bi sıkıntı var
                    ysayisi.setText("" + ysayac);


                    newNumber();
                    System.out.println("dogru bitis" + index);

                    break;
                //

                case R.id.btnyanlis:
                    if (!wordOne.equals(wordTwo)) {
                        ++dsayac;
                        CountDownTimer countDownTimer2 = new CountDownTimer(a, 1000) {
                            @Override
                            public void onTick(long millisUntilFinished) {

                                ply[0] = MediaPlayer.create(DogruYanlisActivity.this, R.raw.ses1);
                                ply[0].start();
                            }

                            @Override
                            public void onFinish() {

                            }
                        }.start();
                    } else {
                        ysayac++;
                        CountDownTimer countDownTimer2 = new CountDownTimer(a, 1000) {
                            @Override
                            public void onTick(long millisUntilFinished) {

                                ply[0] = MediaPlayer.create(DogruYanlisActivity.this, R.raw.ses2);
                                ply[0].start();
                            }

                            @Override
                            public void onFinish() {

                            }
                        }.start();
                    }


                    System.out.println("yanlis baslangic" + index);
                    dsayisi.setText("" + dsayac);
                    ysayisi.setText("" + ysayac);

                    newNumber();
                    System.out.println("yanlis bitis" + index);

                    break;

                case R.id.btngeritus2:
                    countDownTimer.cancel();
                    Intent d = new Intent(DogruYanlisActivity.this, EgzersizActivity.class);
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
        finish();
        Intent d = new Intent(DogruYanlisActivity.this, EgzersizActivity.class);
        startActivity(d);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);

    }


    public void newNumber() {
        rnd = new Random();
        index = rnd.nextInt(word.size());
        sayi1.setText("" + word.get(index));  //sayı1 dediğimiz düz bir metin olan ifadedir.
    }

}