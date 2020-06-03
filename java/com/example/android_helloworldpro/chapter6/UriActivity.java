package com.example.android_helloworldpro.chapter6;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.android_helloworldpro.R;

public class UriActivity extends AppCompatActivity {
    Button uriBtn1;
    Button uriBtn2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uri);
        uriBtn1= (Button) findViewById(R.id.uriBtn1);
        uriBtn2= (Button) findViewById(R.id.uriBtn2);
        uriBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //打开网页
                Intent intent=new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                Uri data =Uri.parse("http://www.fujunyu.top:666/9675ab8e/");
                //利用Data属性
                intent.setData(data);
                startActivity(intent);
            }
        });

        uriBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //打开网页
                Intent intent=new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                Uri data =Uri.parse("http://cloud.fujunyu.top/index.php?user/login");
                //利用Data属性
                intent.setData(data);
                startActivity(intent);
            }
        });
    }
}
