package com.example.pult33;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;

import java.util.Objects;

public class Radio_Activity extends AppCompatActivity {
    final String TAG = "LifeCycle";
    public static boolean BtOn;
/*############################ЗАПУСК####################################*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"Radio_Activity.onCreate");
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_radio_);

    }

    /*############################РАБОТА####################################*/
    @Override
    public void onResume() {
        super.onResume();
        IntStart();
        RadioScript.setSelection(25);
        Log.d(TAG,"Radio_Activity.onResume");
    }

    /*############################СТОПЭ####################################*/
    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG,"Radio_Activity.onStop");
    }

    /*############################УБЕЙСЯ###################################*/
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"Radio_Activity.onDestroy");
    }


    /*############################ИНТЕРФЕЙС###################################*/
    /*################Старт интерфейса######################*/
    private void IntStart(){
        ButBackToMain = findViewById(R.id.ButBackR);
        ButR1 = findViewById(R.id.ButRadio1);
        ButR2 = findViewById(R.id.ButRadio2);
        ButR3 = findViewById(R.id.ButRadio3);
        ButR4 = findViewById(R.id.ButRadio4);
        ButR5 = findViewById(R.id.ButRadio5);
        ButR6 = findViewById(R.id.ButRadio6);
        ButR7 = findViewById(R.id.ButRadio7);
        ButR8 = findViewById(R.id.ButRadio8);
        RadioScript = findViewById(R.id.spinner);
        ButBackToMain.setOnClickListener(OclBtnR);
        ButR1.setOnClickListener(OclBtnR);
        ButR2.setOnClickListener(OclBtnR);
        ButR3.setOnClickListener(OclBtnR);
        ButR4.setOnClickListener(OclBtnR);
        ButR5.setOnClickListener(OclBtnR);
        ButR6.setOnClickListener(OclBtnR);
        ButR7.setOnClickListener(OclBtnR);
        ButR8.setOnClickListener(OclBtnR);
        RadioScript.setOnItemSelectedListener(OislSpnR);
    }

    /*################Обработка кнопок######################*/
    Button ButBackToMain;
    Button ButR1, ButR2, ButR3, ButR4, ButR5, ButR6, ButR7, ButR8;
    Button.OnClickListener OclBtnR = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.ButBackR:
                    Intent MainRun = new Intent(Radio_Activity.this, MainActivity.class);
                    startActivity(MainRun);
                    finish();
                    break;
                case R.id.ButRadio1 :
                    MainActivity.BtSend("1:2=1;");  //Радиво поиск вперед
                    break;

                case R.id.ButRadio2 :
                    MainActivity.BtSend("1:2=2;");  //Радиво поиск назад
                    break;

                case R.id.ButRadio3 :
                    MainActivity.BtSend("1:2=3;");  //Радиво частота +
                    break;

                case R.id.ButRadio4 :
                    MainActivity.BtSend("1:2=4;");  //Радиво частота -
                    break;

                case R.id.ButRadio5 :
                    MainActivity.BtSend("1:2=6;");  //Радиво громче
                    break;

                case R.id.ButRadio6 :
                    MainActivity.BtSend("1:2=5;");  //Радиво тише
                    break;

                case R.id.ButRadio7 :
                    MainActivity.BtSend("1:2=7;");  //Радиво канал +
                    break;

                case R.id.ButRadio8 :
                    MainActivity.BtSend("1:2=8;");  //Радиво канал -
                    break;
                default:
                    break;

            }


        }
    };

/*################Обработка спиннера######################*/
Spinner RadioScript;
//ArrayAdapter adapter = (ArrayAdapter) RadioScript.getAdapter();

Spinner.OnItemSelectedListener OislSpnR = new Spinner.OnItemSelectedListener(){
    @Override
    public void onItemSelected(AdapterView<?> parent, View itemSelected, int selectedItemPosition, long selectedId) {
        //String selected = RadioScript.getSelectedItem().toString();
        int position = RadioScript.getSelectedItemPosition();
        MainActivity.BtSend("1:3="+position+";");
        Log.d(TAG,"1:3="+position+";");
    }
    public void onNothingSelected(AdapterView<?> parent) {
    }
};


/*
    ToggleButton.OnCheckedChangeListener SWBList = new ToggleButton.OnCheckedChangeListener(){
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                MainActivity.BtSend("2:1=1;");
                Log.d(TAG, "2:1=1;");
            }
            else
            {
                MainActivity.BtSend("2:1=0;");
                Log.d(TAG,"2:1=0;");
            }
        }
    };*/

/*
    RadioScript.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        public void onItemSelected(AdapterView<?> parent,
                View itemSelected, int selectedItemPosition, long selectedId) {

            String[] choose = getResources().getStringArray(R.array.animals);
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Ваш выбор: " + choose[selectedItemPosition], Toast.LENGTH_SHORT);
            toast.show();
        }
        public void onNothingSelected(AdapterView<?> parent) {
        }
    });
*/

/*//Команды на Радиво Станции
#define RPr1 1                // -1----87.50	  Дорожное радио
#define RPr2 2                // -2----88.00	  Ретро FM
#define RPr3 3                // -3----88.40	  Авторадио
#define RPr4 4                // -4----88.90	  Радио Юмор FM
#define RPr5 5                // -5----89.30	  Радио Вести FM
#define RPr6 6                // -6----89.70	  Радио Зенит
#define RPr7 7                // -7----90.10	  Радио Эрмитаж
#define RPr8 8                // -8----90.60	  Радио для двоих
#define RPr9 9                // -9----91.10	  Новое Радио
#define RPr10 10              //-10----91.50	  Радио Эхо Петербурга
#define RPr11 11              //-11----92.00	  Комсомольская правда   (план)
#define RPr12 12              //-12----92.40	  Радио Хит FM   (план)
#define RPr13 13              //-13----92.90	  IZ.ru (звук)
#define RPr14 14              //-14----95.00	  Радио Energy
#define RPr15 15              //-15----95.50	  Studio 21
#define RPr16 16              //-16----95.90	  Comedy Radio
#define RPr17 17              //-17----97.00	  Радио Дача
#define RPr18 18              //-18----98.60	  Royal Radio
#define RPr19 19              //-19----99.00	  Радио России С.-Петербург FM
#define RPr20 20              //-20----100.10	  Радио Популярная классика
#define RPr21 21              //-21----100.50	  Радио Европа Плюс
#define RPr22 22              //-22----100.90	  Радио Питер FM
#define RPr23 23              //-23----101.40	  Эльдорадио
#define RPr24 24              //-24----102.00	  Радио Страна FM
#define RPr25 25              //-25----102.40	  Radio METRO
#define RPr26 26              //-26----102.80	  Радио Максимум
#define RPr27 27              //-27----103.40	  Радио DFM
#define RPr28 28              //-28----103.70	  Детское радио
#define RPr29 29              //-29----104.00	  НАШЕ Радио
#define RPr30 30              //-30----104.40	  Радио Шансон
#define RPr31 31              //-31----104.80	  IZ.ru (звук)
#define RPr32 32              //-32----105.30	  Love Радио
#define RPr33 33              //-33----105.90	  Радио Монте-Карло
#define RPr34 34              //-34----106.30	  Радио Рекорд
#define RPr35 35              //-35----107.00	  Радио Маяк
#define RPr36 36              //-36----107.40	  Радио Business FM
#define RPr37 37              //-37----107.80	  Русское Радио
*/
}
