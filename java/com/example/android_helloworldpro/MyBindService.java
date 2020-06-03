package com.example.android_helloworldpro;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyBindService extends Service {
    String Tag="myBinderService";
    MyBinder myBinder=new MyBinder();
    @Override
    public IBinder onBind(Intent intent) {
        Log.i(Tag,"onBind");
        return myBinder;
    }

    @Override
    public void onCreate() {
        Log.i(Tag,"onCreate");
        super.onCreate();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i(Tag,"onUnbind");
        return super.onUnbind(intent);
    }

    public class MyBinder extends Binder {
        public MyBindService getMyBindService(){
            return MyBindService.this;
        }
    }
    public double pingfang(double x){
        return x*x;
    }

    public double lifang(double x){
        return x*x*x;
    }
}
