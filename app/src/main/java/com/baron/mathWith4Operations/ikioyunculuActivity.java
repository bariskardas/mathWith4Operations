package com.baron.mathWith4Operations;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class ikioyunculuActivity extends AppCompatActivity implements View.OnClickListener {
    int sayi_1,sayi_2,sayi_1_2,sayi_2_2,sonucc,sonucc_2,cevap,cevap_2,dsayac=0,dsayac_2 =0;
    TextView sayi1,sayi1_2,sayi2,sayi2_2,dsayisi,dsayisi_2,sonuc,sonuc_2;
    int digit, digit_2;
    long number, number_2;
    Button delete_1, delete_2,btncevapla_1,btncevapla_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ikioyuncu);

        sonuc = (TextView) findViewById(R.id.txtSonuc);
        sonuc_2 = (TextView) findViewById(R.id.txtSonuc_2);
        delete_1 = (Button) findViewById(R.id.btndelete1);
        delete_2 = (Button) findViewById(R.id.btndelete2);
        sayi1 = (TextView) findViewById(R.id.txtSayi1);
        sayi1_2 = (TextView) findViewById(R.id.txtSayi1_2);
        sayi2 = (TextView) findViewById(R.id.txtSayi2);
        sayi2_2 = (TextView) findViewById(R.id.txtSayi2_2);
        dsayisi = (TextView) findViewById(R.id.txtdsayisi);
        dsayisi_2 = (TextView) findViewById(R.id.txtdsayisi_2);
        btncevapla_1 = (Button) findViewById(R.id.btncevapla_1);
        btncevapla_2 = (Button) findViewById(R.id.btncevapla_2);
        Button btn0 = (Button) findViewById(R.id.btn0);
        Button btn0_2 = (Button) findViewById(R.id.btn0_2);
        Button btn1 = (Button) findViewById(R.id.btn1);
        Button btn1_2 = (Button) findViewById(R.id.btn1_2);
        Button btn2 = (Button) findViewById(R.id.btn2);
        Button btn2_2 = (Button) findViewById(R.id.btn2_2);
        Button btn3 = (Button) findViewById(R.id.btn3);
        Button btn3_2 = (Button) findViewById(R.id.btn3_2);
        Button btn4 = (Button) findViewById(R.id.btn4);
        Button btn4_2 = (Button) findViewById(R.id.btn4_2);
        Button btn5 = (Button) findViewById(R.id.btn5);
        Button btn5_2 = (Button) findViewById(R.id.btn5_2);
        Button btn6 = (Button) findViewById(R.id.btn6);
        Button btn6_2 = (Button) findViewById(R.id.btn6_2);
        Button btn7 = (Button) findViewById(R.id.btn7);
        Button btn7_2 = (Button) findViewById(R.id.btn7_2);
        Button btn8 = (Button) findViewById(R.id.btn8);
        Button btn8_2 = (Button) findViewById(R.id.btn8_2);
        Button btn9 = (Button) findViewById(R.id.btn9);
        Button btn9_2 = (Button) findViewById(R.id.btn9_2);

        delete_1.setOnClickListener (this);
        delete_2.setOnClickListener (this);
        sayi1.setOnClickListener (this);
        sayi2.setOnClickListener (this);
        dsayisi.setOnClickListener (this);
        btncevapla_1.setOnClickListener (this);
        btncevapla_2.setOnClickListener (this);
        sonuc.setOnClickListener (this);



        Random rastgelesayiOlusturucu = new Random();
        int rastgelesayi = rastgelesayiOlusturucu.nextInt(11)+1;
        Random rastgelesayiOlusturucu2 = new Random();
        int rastgelesayi2 = rastgelesayiOlusturucu2.nextInt(11)+1;
        sayi1.setText(rastgelesayi + "");
        sayi1_2.setText(rastgelesayi + "");
        sayi2.setText(rastgelesayi2 + "");
        sayi2_2.setText(rastgelesayi2 + "");

    }


    @Override
    public void onClick(View v) {
        try {
        switch (v.getId()) {

            case R.id.btncevapla_1:
                sayi_1 = Integer.parseInt(sayi1.getText().toString());
                sayi_2 = Integer.parseInt(sayi2.getText().toString());
                cevap = sayi_1 * sayi_2;
                sonucc = Integer.parseInt(sonuc.getText().toString());

                if (sonucc == cevap) {
                    ++dsayac;

                }
                else {
                    --dsayac;

                }


                if(dsayac == 9){

                    Intent a = new Intent(ikioyunculuActivity.this, K1Activity.class);
                    startActivity(a);


                }
                Random rastgelesayiOlusturucu = new Random();
                int rastgelesayi = rastgelesayiOlusturucu.nextInt(11)+1; // 0-9 du +1 geldi yeni hali 1-10 geliyor
                sayi1.setText(rastgelesayi + "");

                Random rastgelesayiOlusturucu2 = new Random();
                int rastgelesayi2 = rastgelesayiOlusturucu.nextInt(11)+1;
                sayi2.setText(rastgelesayi2 + "");

                dsayisi.setText("" + dsayac);
                sonuc.setText("");

                break;


            case R.id.btncevapla_2:
                sayi_1_2 = Integer.parseInt(sayi1_2.getText().toString());
                sayi_2_2 = Integer.parseInt(sayi2_2.getText().toString());
                cevap_2 = sayi_1_2 * sayi_2_2;
                sonucc_2 = Integer.parseInt(sonuc_2.getText().toString());

                if (sonucc_2 == cevap_2) {
                    ++dsayac_2;

                }
                else {
                    --dsayac_2;

                }


                if(dsayac_2 == 9){

                    Intent a = new Intent(ikioyunculuActivity.this, K2Activity.class);
                    startActivity(a);


                }
                Random r3 = new Random();
                int r_2 = r3.nextInt(11); // 0-9 du +1 geldi yeni hali 1-10 geliyor
                sayi1_2.setText(r_2 + "");

                Random r4 = new Random();
                int r_3 = r4.nextInt(11);
                sayi2_2.setText(r_3 + "");

                dsayisi_2.setText("" + dsayac_2);
                sonuc_2.setText("");



                break;



            case R.id.btn0:
                Button button0 = (Button) v;
                sonuc.setText(sonuc.getText().toString() + button0.getText().toString());
                break;

            case R.id.btn1:
                Button button1 = (Button) v;
                sonuc.setText(sonuc.getText().toString() + button1.getText().toString());
                break;

            case R.id.btn2:
                Button button2 = (Button) v;
                sonuc.setText(sonuc.getText().toString() + button2.getText().toString());
                break;

            case R.id.btn3:
                Button button3 = (Button) v;
                sonuc.setText(sonuc.getText().toString() + button3.getText().toString());
                break;

            case R.id.btn4:
                Button button4 = (Button) v;
                sonuc.setText(sonuc.getText().toString() + button4.getText().toString());
                break;

            case R.id.btn5:
                Button button5 = (Button) v;
                sonuc.setText(sonuc.getText().toString() + button5.getText().toString());
                break;

            case R.id.btn6:
                Button button6 = (Button) v;
                sonuc.setText(sonuc.getText().toString() + button6.getText().toString());
                break;

            case R.id.btn7:
                Button button7 = (Button) v;
                sonuc.setText(sonuc.getText().toString() + button7.getText().toString());
                break;

            case R.id.btn8:
                Button button8 = (Button) v;
                sonuc.setText(sonuc.getText().toString() + button8.getText().toString());
                break;

            case R.id.btn9:
                Button button9 = (Button) v;
                sonuc.setText(sonuc.getText().toString() + button9.getText().toString());
                break;

            case R.id.btn0_2:
                Button button0_2 = (Button) v;
                sonuc_2.setText(sonuc_2.getText().toString() + button0_2.getText().toString());
                break;

            case R.id.btn1_2:
                Button button1_2 = (Button) v;
                sonuc_2.setText(sonuc_2.getText().toString() + button1_2.getText().toString());
                break;

            case R.id.btn2_2:
                Button button2_2 = (Button) v;
                sonuc_2.setText(sonuc_2.getText().toString() + button2_2.getText().toString());
                break;

            case R.id.btn3_2:
                Button button3_2 = (Button) v;
                sonuc_2.setText(sonuc_2.getText().toString() + button3_2.getText().toString());
                break;

            case R.id.btn4_2:
                Button button4_2 = (Button) v;
                sonuc_2.setText(sonuc_2.getText().toString() + button4_2.getText().toString());
                break;

            case R.id.btn5_2:
                Button button5_2 = (Button) v;
                sonuc_2.setText(sonuc_2.getText().toString() + button5_2.getText().toString());
                break;

            case R.id.btn6_2:
                Button button6_2 = (Button) v;
                sonuc_2.setText(sonuc_2.getText().toString() + button6_2.getText().toString());
                break;

            case R.id.btn7_2:
                Button button7_2 = (Button) v;
                sonuc_2.setText(sonuc_2.getText().toString() + button7_2.getText().toString());
                break;

            case R.id.btn8_2:
                Button button8_2 = (Button) v;
                sonuc_2.setText(sonuc_2.getText().toString() + button8_2.getText().toString());
                break;

            case R.id.btn9_2:
                Button button9_2 = (Button) v;
                sonuc_2.setText(sonuc_2.getText().toString() + button9_2.getText().toString());
                break;


            case R.id.btndelete1:
                String str = sonuc.getText().toString();
                if (str.length() > 0) {
                    str = str.substring(0, str.length() - 1);
// Now set this Text to your edit text
                    sonuc.setText(str);
                }
                break;


            case R.id.btndelete2:
                String str2 = sonuc_2.getText().toString();
                if (str2.length() > 0) {
                    str2 = str2.substring(0, str2.length() - 1);
// Now set this Text to your edit text
                    sonuc_2.setText(str2);
                }
                break;
        }

        } catch (NumberFormatException ex) { // handle your exception
            ex.printStackTrace();
        }

    }



   /* public void numberPressed(View v){

        Button b = (Button) v;

        digit = Integer.parseInt(b.getText().toString());

        number = Long.parseLong(cevap_1.getText().toString());

        number = number * 10 + digit;

        cevap_1.setText(String.valueOf(number));

    }

    public void numberPressed2(View v){

        Button a = (Button) v;

        digit_2 = Integer.parseInt(a.getText().toString());

        number_2 = Long.parseLong(cevap_2.getText().toString());

        number_2 = number_2 * 10 + digit_2;

        cevap_2.setText(String.valueOf(number_2));

    }


    public void numberPressed3(View v){
        String s = cevap_2.getText().toString();
        if (s.length() > 0){
            s = s.substring(0, s.length() - 1);
// Now set this Text to your edit text
            cevap_2.setText(s);
        }

    }

*/
   @Override
   public void onBackPressed() {
       AlertDialog.Builder builder = new AlertDialog.Builder(this);
       builder.setCancelable(false);
       builder.setMessage(getResources().getString(R.string.cikis_bilgi));

       builder.setPositiveButton(getResources().getString(R.string.evet), new DialogInterface.OnClickListener() {

           @Override
           public void onClick(DialogInterface dialog, int which) {
               // Evet'e basılınca yapılacak işlemleri yazınız
               Intent a = new Intent(ikioyunculuActivity.this, EgzersizActivity.class);
               startActivity(a);

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
