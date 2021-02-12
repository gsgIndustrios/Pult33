package com.example.pult33;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Objects;
import java.util.UUID;


public class MainActivity extends AppCompatActivity {


    public static boolean BtOn;
    final String TAG = "LifeCycle";
    /*#######################СТАРТ###########################*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).hide();
        Log.d(TAG,"MainActivity.onCreate");
        /*#######################ИНТЕРФЕЙС###########################*/
        LightActy = findViewById(R.id.ButLight);
        SoundActy = findViewById(R.id.ButSound8);
        RadioActy = findViewById(R.id.ButRadio);
        DiscoHeadActy = findViewById(R.id.butDiscoHead);
        DiscoBallActy = findViewById(R.id.ButDiscoBall);
        ButCls = findViewById(R.id.ButClose);
        ButCt = findViewById(R.id.ButConnect);
        LightActy.setOnClickListener(OclBtn);
        SoundActy.setOnClickListener(OclBtn);
        RadioActy.setOnClickListener(OclBtn);
        DiscoHeadActy.setOnClickListener(OclBtn);
        DiscoBallActy.setOnClickListener(OclBtn);
        ButCls.setOnClickListener(OclBtn);
        ButCt.setOnClickListener(OclBtn);

    }


    /*############################РАБОТА####################################*/
    @Override
    public void onResume() {
        if (BtOn){
            LightActy.setVisibility(View.VISIBLE);
            SoundActy.setVisibility(View.VISIBLE);
            RadioActy.setVisibility(View.VISIBLE);
            DiscoHeadActy.setVisibility(View.VISIBLE);
            DiscoBallActy.setVisibility(View.VISIBLE);
        }
        else if(Light_Activity.BtOn){
            LightActy.setVisibility(View.VISIBLE);
            SoundActy.setVisibility(View.VISIBLE);
            RadioActy.setVisibility(View.VISIBLE);
            DiscoHeadActy.setVisibility(View.VISIBLE);
            DiscoBallActy.setVisibility(View.VISIBLE);
        }
        else if(Sound_Activity.BtOn){
            LightActy.setVisibility(View.VISIBLE);
            SoundActy.setVisibility(View.VISIBLE);
            RadioActy.setVisibility(View.VISIBLE);
            DiscoHeadActy.setVisibility(View.VISIBLE);
            DiscoBallActy.setVisibility(View.VISIBLE);
        }
        else if(Radio_Activity.BtOn){
            LightActy.setVisibility(View.VISIBLE);
            SoundActy.setVisibility(View.VISIBLE);
            RadioActy.setVisibility(View.VISIBLE);
            DiscoHeadActy.setVisibility(View.VISIBLE);
            DiscoBallActy.setVisibility(View.VISIBLE);
        }
        else if(DiscoHead_Activity.BtOn){
            LightActy.setVisibility(View.VISIBLE);
            SoundActy.setVisibility(View.VISIBLE);
            RadioActy.setVisibility(View.VISIBLE);
            DiscoHeadActy.setVisibility(View.VISIBLE);
            DiscoBallActy.setVisibility(View.VISIBLE);
        }
        else if(DiscoBall_Activity.BtOn){
            LightActy.setVisibility(View.VISIBLE);
            SoundActy.setVisibility(View.VISIBLE);
            RadioActy.setVisibility(View.VISIBLE);
            DiscoHeadActy.setVisibility(View.VISIBLE);
            DiscoBallActy.setVisibility(View.VISIBLE);
        }
        else {
            LightActy.setVisibility(View.INVISIBLE);
            SoundActy.setVisibility(View.INVISIBLE);
            RadioActy.setVisibility(View.INVISIBLE);
            DiscoHeadActy.setVisibility(View.INVISIBLE);
            DiscoBallActy.setVisibility(View.INVISIBLE);
        }
        super.onResume();
        Log.d(TAG,"MainActivity.onResume");
    }

    /*############################СТОПЭ####################################*/
    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG,"MainActivity.onStop");
    }

    /*############################УБЕЙСЯ###################################*/

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"MainActivity.onDestroy");
    }
    @Override
    public void onRestart(){
        super.onRestart();

        Log.d(TAG,"MainActivity.onRestart");
    }
    /*###############################ИНТЕРФЕЙС#############################*/

    public Button LightActy, SoundActy, RadioActy, ButCt, ButCls,DiscoHeadActy,DiscoBallActy;

    /*################Обработка кнопок######################*/

    Button.OnClickListener OclBtn = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.ButLight:
                    //Toast.makeText(getBaseContext(), "ButLight", Toast.LENGTH_LONG).show();
                    Intent LightRun = new Intent(MainActivity.this, Light_Activity.class);
                    startActivity(LightRun);
                    break;
                case R.id.ButSound8:
                    //Toast.makeText(getBaseContext(), "ButSound", Toast.LENGTH_LONG).show();
                    Intent SoundRun = new Intent(MainActivity.this, Sound_Activity.class);
                    startActivity(SoundRun);
                    break;
                case R.id.ButRadio:
                    //Toast.makeText(getBaseContext(), "ButRadio", Toast.LENGTH_LONG).show();
                    Intent RadioRun = new Intent(MainActivity.this, Radio_Activity.class);
                    startActivity(RadioRun);
                    break;
                case R.id.butDiscoHead:
                    //Toast.makeText(getBaseContext(), "ButRadio", Toast.LENGTH_LONG).show();
                    Intent DiscoRun = new Intent(MainActivity.this, DiscoHead_Activity.class);
                    startActivity(DiscoRun);
                    break;
                case R.id.ButDiscoBall:
                    //Toast.makeText(getBaseContext(), "ButRadio", Toast.LENGTH_LONG).show();
                    Intent BallRun = new Intent(MainActivity.this, DiscoBall_Activity.class);
                    startActivity(BallRun);
                    break;
                case R.id.ButClose:
                    BtClose();
                    onDestroy();
                    finish();
                    break;
                case R.id.ButConnect:
                    //ЗАПУСК BLUETOOTH
                    if (BtStart()) {
                        Log.d(TAG,"ЗАПУСК");
                    } else {
                        Log.d(TAG,"Ошибка в BtStart");
                    }
                    if (BtDrive(macAddress)) {
                        Log.d(TAG,"КОННЕКТ");
                    } else {

                        Log.d(TAG,"КОННЕКТ/ОБЛОМ");
                    }
                    BtOn=true;
                    onResume();
                    break;
                default:
                    break;
            }
        }
    };
    /*################БЛЮПУП######################*/
    /*################ПЕРЕМЕННЫЕ######################*/
    //БЛЮПУП
    private static final int REQUEST_ENABLE_BT = 1;
    public BluetoothAdapter btAdapter;
    private static final UUID MY_UUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
    public static MainActivity.ConnectedThread MyThread = null;
    public String macAddress = "20:16:07:18:83:95";
    /*############################СТАРТ####################################*/
    public boolean BtStart() {
        btAdapter = BluetoothAdapter.getDefaultAdapter();
        boolean Error;
        if (btAdapter == null) {
            Error=true;
        }
        else {
            if (btAdapter.isEnabled()) {
                Error=false;
            } else {
                //Включить bluetooth
                Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
                Error=false;
            }
        }
        return Error;
    }
    /*############################РАБОТА####################################*/
    public boolean BtDrive(String MacAdress) {
        BluetoothDevice device = btAdapter.getRemoteDevice(MacAdress);
        BluetoothSocket btSocket;
        try {
            btSocket = device.createRfcommSocketToServiceRecord(MY_UUID);
            Log.d(TAG,"создан сокет: ");
        } catch (IOException e) {
            Log.d(TAG,"В onResume() Не могу создать сокет: ");
            return false;
        }
        btAdapter.cancelDiscovery();
        try {
            btSocket.connect();
        } catch (IOException e) {
            Log.d(TAG,"Не коннектится ");
            return false;
        }
        Log.d(TAG,"***Соединился***");
        MyThread = new ConnectedThread(btSocket);
        MyThread.start();
        return true;
    }

    /*############################ПОСЫЛКА##################################*/
    public static void BtSend(String message) {
        byte[] msgBuffer = message.getBytes();
        try {
            OutStream.write(msgBuffer);

        } catch (IOException ignored) {

        }

    }

/*############################ВЫКЛЮЧИТЬ BLUETOOTH##################################*/
    public void BtClose(){
        if (MyThread.status_OutStream() != null) {
            try {
                MyBtSocket.close();
            } catch (IOException e) {
                Log.d(TAG,"***Не могу закрыть сокет***");
                return;
            }
        }

        Log.d(TAG,"***Cокет закрыт***");
    }
    /*########################ОТДЕЛЬНЫЙ ПОТОК ДЛЯ ПЕРЕДАЧИ################################*/
    public BluetoothSocket MyBtSocket;
    public static OutputStream OutStream;
    public InputStream InStream;
    public class ConnectedThread extends Thread {

        ConnectedThread(BluetoothSocket socket) {
            MyBtSocket = socket;
            InputStream tmpIn = null;
            OutputStream tmpOut = null;
            try {
                tmpIn = socket.getInputStream();
                tmpOut = socket.getOutputStream();
            } catch (IOException ignored) {
            }

            InStream = tmpIn;
            OutStream = tmpOut;
        }
        Object status_OutStream() {
            if (OutStream == null) {
                return null;
            } else {
                return OutStream;
            }
        }

    }
}
