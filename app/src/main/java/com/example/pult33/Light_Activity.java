package com.example.pult33;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.ToggleButton;

import java.util.Objects;


public class Light_Activity extends AppCompatActivity {
    final String TAG = "LifeCycle";

public static boolean BtOn;
/*############################ЗАПУСК####################################*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"LightActivity.onCreate");
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_light_);
    }

/*############################РАБОТА####################################*/
    @Override
    public void onResume() {
        super.onResume();
        IntStart();
        Log.d(TAG,"LightActivity.onResume");
    }

/*############################СТОПЭ####################################*/
    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG,"LightActivity.onStop");
    }

/*############################УБЕЙСЯ###################################*/
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"LightActivity.onDestroy");
    }


/*############################ИНТЕРФЕЙС###################################*/



/*################Старт интерфейса######################*/
    private void IntStart(){
        ButBackToMain = findViewById(R.id.ButBackL);
        ButLightBalkon = findViewById(R.id.ButLightB);
        ButLightRoom = findViewById(R.id.ButLightR);
        ButLightDop1 = findViewById(R.id.ButLight1);
        ButLightDop2 = findViewById(R.id.ButLight2);
        SeekBalkon = findViewById(R.id.seekB);
        SeekRoom = findViewById(R.id.seekR);
        SeekDop1 = findViewById(R.id.seek1);
        SeekDop2 = findViewById(R.id.seek2);
        ButBackToMain.setOnClickListener(OclBtnL);
        ButLightBalkon.setOnCheckedChangeListener(SWBList);
        ButLightRoom.setOnCheckedChangeListener(SWRList);
        ButLightDop1.setOnCheckedChangeListener(SW1List);
        ButLightDop2.setOnCheckedChangeListener(SW2List);
        SeekBalkon.setOnSeekBarChangeListener(SeekBList);
        SeekRoom.setOnSeekBarChangeListener(SeekRList);
        SeekDop1.setOnSeekBarChangeListener(Seek1List);
        SeekDop2.setOnSeekBarChangeListener(Seek2List);
    }

/*################Обработка кнопок######################*/
    Button ButBackToMain;
    Button.OnClickListener OclBtnL = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.ButBackL) {
                Intent MainRun = new Intent(Light_Activity.this, MainActivity.class);
                startActivity(MainRun);
                finish();
            }

        }
    };

/*################Обработка переключателей######################*/
    ToggleButton ButLightBalkon, ButLightRoom,ButLightDop1,ButLightDop2;

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
    };

    ToggleButton.OnCheckedChangeListener SWRList = new ToggleButton.OnCheckedChangeListener(){
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                MainActivity.BtSend("3:1=1;");
                Log.d(TAG, "3:1=1;");
            }
            else
            {
                MainActivity.BtSend("3:1=0;");
                Log.d(TAG,"3:1=0;");
            }
        }
    };
    ToggleButton.OnCheckedChangeListener SW1List = new ToggleButton.OnCheckedChangeListener(){
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                MainActivity.BtSend("6:1=1;");
                Log.d(TAG, "6:1=1;");
            }
            else
            {
                MainActivity.BtSend("6:1=0;");
                Log.d(TAG,"6:1=0;");
            }
        }
    };
    ToggleButton.OnCheckedChangeListener SW2List = new ToggleButton.OnCheckedChangeListener(){
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                MainActivity.BtSend("7:1=1;");
                Log.d(TAG, "7:1=1;");
            }
            else
            {
                MainActivity.BtSend("7:1=0;");
                Log.d(TAG,"7:1=0;");
            }
        }
    };

/*################Обработка ползунков######################*/
    SeekBar SeekBalkon, SeekRoom, SeekDop1,SeekDop2;
    public String SeekVa1B, SeekVa1R,SeekVa11,SeekVa12;
    //Балкон
    SeekBar.OnSeekBarChangeListener SeekBList = new SeekBar.OnSeekBarChangeListener() {
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        SeekVa1B = String.valueOf(SeekBalkon.getProgress());
        }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

        }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        SeekVa1B = ("2:2="+SeekVa1B+";");
        MainActivity.BtSend(SeekVa1B);
        }
    };

    SeekBar.OnSeekBarChangeListener SeekRList = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            SeekVa1R = String.valueOf(SeekRoom.getProgress());
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            SeekVa1R = ("3:2="+SeekVa1R+";");
            MainActivity.BtSend(SeekVa1R);
        }
    };

    SeekBar.OnSeekBarChangeListener Seek1List = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            SeekVa11 = String.valueOf(SeekDop1.getProgress());
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            SeekVa11 = ("6:2="+SeekVa11+";");
            MainActivity.BtSend(SeekVa11);
        }
    };

    SeekBar.OnSeekBarChangeListener Seek2List = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            SeekVa12 = String.valueOf(SeekDop2.getProgress());
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            SeekVa12 = ("7:2="+SeekVa12+";");
            MainActivity.BtSend(SeekVa12);
        }
    };


}
