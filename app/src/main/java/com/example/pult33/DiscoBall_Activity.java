package com.example.pult33;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import java.util.Objects;


public class DiscoBall_Activity extends AppCompatActivity {
    final String TAG = "LifeCycle";
    public static boolean BtOn;
/*############################ЗАПУСК####################################*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"DiscoBallActivity.onCreate");
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_discoball);
    }

/*############################РАБОТА####################################*/
    @Override
    public void onResume() {
        super.onResume();
        IntStart();
        Log.d(TAG,"DiscoBallActivity.onResume");
    }

/*############################СТОПЭ####################################*/
    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG,"DiscoBallActivity.onStop");
    }

/*############################УБЕЙСЯ###################################*/
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"DiscoBallActivity.onDestroy");
    }


/*############################ИНТЕРФЕЙС###################################*/



/*################Старт интерфейса######################*/
    private void IntStart(){
        ButBackToMain = findViewById(R.id.butBackDiskoB);
        SeekBall1 = findViewById(R.id.seekDiskoBall1);
        SeekBall2 = findViewById(R.id.seekDiskoBall2);
        SeekBall3 = findViewById(R.id.seekDiskoBall3);
        SeekBall4 = findViewById(R.id.seekDiskoBall4);
        SeekBall5 = findViewById(R.id.seekDiskoBall5);
        SeekBall6 = findViewById(R.id.seekDiskoBall6);
        ButBackToMain.setOnClickListener(OclbutBackDiskoB);
        SeekBall1.setOnSeekBarChangeListener(SeekBall1List);
        SeekBall2.setOnSeekBarChangeListener(SeekBall2List);
        SeekBall3.setOnSeekBarChangeListener(SeekBall3List);
        SeekBall4.setOnSeekBarChangeListener(SeekBall4List);
        SeekBall5.setOnSeekBarChangeListener(SeekBall5List);
        SeekBall6.setOnSeekBarChangeListener(SeekBall6List);
    }

    /*################Обработка кнопок######################*/
    Button ButBackToMain;
    Button.OnClickListener OclbutBackDiskoB = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.butBackDiskoB) {
                Intent MainRun = new Intent(DiscoBall_Activity.this, MainActivity.class);
                startActivity(MainRun);
                finish();
            }

        }
    };

/*################Обработка ползунков######################*/
    SeekBar SeekBall1, SeekBall2, SeekBall3,SeekBall4,SeekBall5,SeekBall6;
    public String SeekBallVal1,SeekBallVal2,SeekBallVal3,SeekBallVal4,SeekBallVal5,SeekBallVal6;
    //SeekBall1
    SeekBar.OnSeekBarChangeListener SeekBall1List = new SeekBar.OnSeekBarChangeListener() {
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        SeekBallVal1 = String.valueOf(SeekBall1.getProgress());
        }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

        }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        SeekBallVal1 = ("4:1="+SeekBallVal1+";");
        MainActivity.BtSend(SeekBallVal1);
        }
    };

    //SeekBall2
    SeekBar.OnSeekBarChangeListener SeekBall2List = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            SeekBallVal2 = String.valueOf(SeekBall2.getProgress());
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            SeekBallVal2 = ("4:2="+SeekBallVal2+";");
            MainActivity.BtSend(SeekBallVal2);
        }
    };

    //SeekBall3
    SeekBar.OnSeekBarChangeListener SeekBall3List = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            SeekBallVal3 = String.valueOf(SeekBall3.getProgress());
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            SeekBallVal3 = ("4:3="+SeekBallVal3+";");
            MainActivity.BtSend(SeekBallVal3);
        }
    };

    //SeekBall4
    SeekBar.OnSeekBarChangeListener SeekBall4List = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            SeekBallVal4 = String.valueOf(SeekBall4.getProgress());
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            SeekBallVal4 = ("4:4="+SeekBallVal4+";");
            MainActivity.BtSend(SeekBallVal4);
        }
    };

    //SeekBall5
    SeekBar.OnSeekBarChangeListener SeekBall5List = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            SeekBallVal5 = String.valueOf(SeekBall5.getProgress());
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            SeekBallVal5 = ("4:5="+SeekBallVal5+";");
            MainActivity.BtSend(SeekBallVal5);
        }
    };

    //SeekBall6
    SeekBar.OnSeekBarChangeListener SeekBall6List = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            SeekBallVal6 = String.valueOf(SeekBall6.getProgress());
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            SeekBallVal6 = ("4:6="+SeekBallVal6+";");
            MainActivity.BtSend(SeekBallVal6);
        }
    };


}
