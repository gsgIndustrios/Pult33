package com.example.pult33;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import java.util.Objects;


public class DiscoHead_Activity extends AppCompatActivity {
    final String TAG = "LifeCycle";

public static boolean BtOn;
/*############################ЗАПУСК####################################*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"DiscoHeadActivity.onCreate");
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_discohead);
    }

/*############################РАБОТА####################################*/
    @Override
    public void onResume() {
        super.onResume();
        IntStart();
        Log.d(TAG,"DiscoHead_Activity.onResume");
    }

/*############################СТОПЭ####################################*/
    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG,"DiscoHead_Activity.onStop");
    }

/*############################УБЕЙСЯ###################################*/
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"DiscoHead_Activity.onDestroy");
    }


/*############################ИНТЕРФЕЙС###################################*/



/*################Старт интерфейса######################*/
    private void IntStart(){
        ButBackToMain = findViewById(R.id.butBackDiskoH);
        SeekDMX1 = findViewById(R.id.seekDiskoHead1);
        SeekDMX2 = findViewById(R.id.seekDiskoHead2);
        SeekDMX3 = findViewById(R.id.seekDiskoHead3);
        SeekDMX4 = findViewById(R.id.seekDiskoHead4);
        SeekDMX5 = findViewById(R.id.seekDiskoHead5);
        SeekDMX6 = findViewById(R.id.seekDiskoHead6);
        ButBackToMain.setOnClickListener(OclbutBackDiskoH);
        SeekDMX1.setOnSeekBarChangeListener(SeekDMX1List);
        SeekDMX2.setOnSeekBarChangeListener(SeekDMX2List);
        SeekDMX3.setOnSeekBarChangeListener(SeekDMX3List);
        SeekDMX4.setOnSeekBarChangeListener(SeekDMX4List);
        SeekDMX5.setOnSeekBarChangeListener(SeekDMX5List);
        SeekDMX6.setOnSeekBarChangeListener(SeekDMX6List);
    }

    /*################Обработка кнопок######################*/
    Button ButBackToMain;
    Button.OnClickListener OclbutBackDiskoH = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.butBackDiskoH) {
                Intent MainRun = new Intent(DiscoHead_Activity.this, MainActivity.class);
                startActivity(MainRun);
                finish();
            }

        }
    };

/*################Обработка ползунков######################*/
    SeekBar SeekDMX1, SeekDMX2, SeekDMX3,SeekDMX4,SeekDMX5,SeekDMX6;
    public String SeekDMXVal1,SeekDMXVal2,SeekDMXVal3,SeekDMXVal4,SeekDMXVal5,SeekDMXVal6;
    //SeekDMX1
    SeekBar.OnSeekBarChangeListener SeekDMX1List = new SeekBar.OnSeekBarChangeListener() {
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        SeekDMXVal1 = String.valueOf(SeekDMX1.getProgress());
        }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

        }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        SeekDMXVal1 = ("5:1="+SeekDMXVal1+";");
        MainActivity.BtSend(SeekDMXVal1);
        }
    };

    //SeekDMX2
    SeekBar.OnSeekBarChangeListener SeekDMX2List = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            SeekDMXVal2 = String.valueOf(SeekDMX2.getProgress());
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            SeekDMXVal2 = ("5:2="+SeekDMXVal2+";");
            MainActivity.BtSend(SeekDMXVal2);
        }
    };

    //SeekDMX3
    SeekBar.OnSeekBarChangeListener SeekDMX3List = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            SeekDMXVal3 = String.valueOf(SeekDMX3.getProgress());
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            SeekDMXVal3 = ("5:3="+SeekDMXVal3+";");
            MainActivity.BtSend(SeekDMXVal3);
        }
    };

    //SeekDMX4
    SeekBar.OnSeekBarChangeListener SeekDMX4List = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            SeekDMXVal4 = String.valueOf(SeekDMX4.getProgress());
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            SeekDMXVal4 = ("5:4="+SeekDMXVal4+";");
            MainActivity.BtSend(SeekDMXVal4);
        }
    };

    //SeekDMX5
    SeekBar.OnSeekBarChangeListener SeekDMX5List = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            SeekDMXVal5 = String.valueOf(SeekDMX5.getProgress());
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            SeekDMXVal5 = ("5:5="+SeekDMXVal5+";");
            MainActivity.BtSend(SeekDMXVal5);
        }
    };

    //SeekDMX6
    SeekBar.OnSeekBarChangeListener SeekDMX6List = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            SeekDMXVal6 = String.valueOf(SeekDMX6.getProgress());
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            SeekDMXVal6 = ("5:6="+SeekDMXVal6+";");
            MainActivity.BtSend(SeekDMXVal6);
        }
    };


}
