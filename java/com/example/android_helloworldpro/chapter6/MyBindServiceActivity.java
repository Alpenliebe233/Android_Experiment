package com.example.android_helloworldpro.chapter6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android_helloworldpro.MyBindService;
import com.example.android_helloworldpro.R;

public class MyBindServiceActivity extends AppCompatActivity {
    String Tag= " MyBindService";
    private MyBindService myBindService;
    private EditText editText;
    private ServiceConnection conn= new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            myBindService=((MyBindService.MyBinder)service).getMyBindService();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            myBindService=null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_bind_service);
        editText=(EditText)findViewById(R.id.number);
    }

    public void getServicePingFang(View view) {
        double x=Double.parseDouble(editText.getText().toString());
        Toast.makeText(this,x+"的平方："+myBindService.pingfang(x),Toast.LENGTH_SHORT).show();
    }

    public void getServiceLiFang(View view) {
        double x=Double.parseDouble(editText.getText().toString());
        Toast.makeText(this,x+"的立方："+myBindService.lifang(x),Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(Tag,"onStart");
        Intent intent=new Intent(this, MyBindService.class);
        bindService(intent,conn, Context.BIND_AUTO_CREATE);//绑定服务
    }

    @Override
    protected void onStop() {
        super.onStop();
        unbindService(conn);
        Log.i(Tag,"onStop");
    }
}
