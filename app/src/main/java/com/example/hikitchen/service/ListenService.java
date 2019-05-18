package com.example.hikitchen.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.example.hikitchen.util.RecogUtil;

public class ListenService extends Service {
    public ListenService() {
    }

    @Override
    public IBinder onBind(Intent intent) {

        throw new UnsupportedOperationException("Not yet implemented");
    }
    @Override
    public void onCreate(){
        super.onCreate();
    }
    @Override
    public int onStartCommand(Intent intent,int flags,int startId){
        RecogUtil.getInstance(getApplicationContext()).start();
        return super.onStartCommand(intent,flags,startId);
    }
    @Override
    public void onDestroy(){
        RecogUtil.getInstance(getApplicationContext()).stop();
        super.onDestroy();
    }
}
