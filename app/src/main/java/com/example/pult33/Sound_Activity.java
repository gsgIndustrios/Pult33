package com.example.pult33;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Objects;

public class Sound_Activity extends AppCompatActivity {
    final String TAG = "LifeCycle";
    public static boolean BtOn;

/*############################ЗАПУСК####################################*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"Sound_Activity.onCreate");
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_sound_);
    }

/*############################РАБОТА####################################*/
    @Override
    public void onResume() {
        super.onResume();
        IntStart();
        Log.d(TAG,"Sound_Activity.onResume");
    }

/*############################СТОПЭ####################################*/
    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG,"Sound_Activity.onStop");
    }

/*############################УБЕЙСЯ###################################*/
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"Sound_Activity.onDestroy");
    }

/*############################ИНТЕРФЕЙС###################################*/
    /*################Старт интерфейса######################*/
    private void IntStart(){
        ButBackToMain = findViewById(R.id.ButBackS);
        ButS1 = findViewById(R.id.ButSound1);
        ButS2 = findViewById(R.id.ButSound2);
        ButS3 = findViewById(R.id.ButSound3);
        ButS4 = findViewById(R.id.ButSound4);
        ButS5 = findViewById(R.id.ButSound5);
        ButS6 = findViewById(R.id.ButSound6);
        ButS7 = findViewById(R.id.ButSound7);
        ButS8 = findViewById(R.id.ButSound8);
        ButS9 = findViewById(R.id.ButSound9);
        ButS10 = findViewById(R.id.ButSound10);
        ButS11 = findViewById(R.id.ButSound11);
        ButS12 = findViewById(R.id.ButSound12);
        ButBackToMain.setOnClickListener(OclBtnS);
        ButS1.setOnClickListener(OclBtnS);
        ButS2.setOnClickListener(OclBtnS);
        ButS3.setOnClickListener(OclBtnS);
        ButS4.setOnClickListener(OclBtnS);
        ButS5.setOnClickListener(OclBtnS);
        ButS6.setOnClickListener(OclBtnS);
        ButS7.setOnClickListener(OclBtnS);
        ButS8.setOnClickListener(OclBtnS);
        ButS9.setOnClickListener(OclBtnS);
        ButS10.setOnClickListener(OclBtnS);
        ButS11.setOnClickListener(OclBtnS);
        ButS12.setOnClickListener(OclBtnS);
    }

/*################Обработка кнопок######################*/
    Button ButBackToMain;
    Button ButS1, ButS2, ButS3, ButS4, ButS5, ButS6, ButS7, ButS8, ButS9, ButS10, ButS11, ButS12;
    Button.OnClickListener OclBtnS = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.ButBackS:
                Intent MainRun = new Intent(Sound_Activity.this, MainActivity.class);
                startActivity(MainRun);
                finish();
                break;

                case R.id.ButSound1 :
                    MainActivity.BtSend("1:1=1;");  //Громче
                break;

                case R.id.ButSound2 :
                    MainActivity.BtSend("1:1=2;");  //Тише

                break;

                case R.id.ButSound3 :
                    MainActivity.BtSend("1:1=3;");  //Бас+

                break;

                case R.id.ButSound4 :
                    MainActivity.BtSend("1:1=4;");  //Бас-

                break;

                case R.id.ButSound5 :
                    MainActivity.BtSend("1:1=5;");  //ВЧ+

                break;

                case R.id.ButSound6 :
                    MainActivity.BtSend("1:1=6;");  //ВЧ-

                break;

                case R.id.ButSound7 :
                    MainActivity.BtSend("1:1=7;");  //Вход 1 стерео

                break;

                case R.id.ButSound8 :
                    MainActivity.BtSend("1:1=8;");  //Вход 2 стерео

                break;

                case R.id.ButSound9 :
                    MainActivity.BtSend("1:1=9;");  //Вход 1 сюрраунд

                break;

                case R.id.ButSound10 :
                    MainActivity.BtSend("1:1=10;"); //Вход 2 сюрраунд

                break;

                case R.id.ButSound11 :
                    MainActivity.BtSend("1:1=11;"); //Баланс левее

                break;

                case R.id.ButSound12 :
                    MainActivity.BtSend("1:1=12;"); //Баланс правее

                break;

                default:
                break;

            }


        }
    };

}
