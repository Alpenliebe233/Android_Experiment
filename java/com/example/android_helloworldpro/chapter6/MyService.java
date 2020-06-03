package com.example.android_helloworldpro.chapter6;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service {
    private String Tag="MyService";
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        double x=intent.getDoubleExtra("x",0.0);
        Toast.makeText(this,x+"的平方为："+(x*x),Toast.LENGTH_SHORT).show();
        Log.i(Tag,"startId="+startId);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.i(Tag,"onDestroy()");
        super.onDestroy();
    }
}
