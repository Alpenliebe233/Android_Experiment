package com.example.android_helloworldpro.chapter6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.android_helloworldpro.R;

public class MyServiceActivity extends AppCompatActivity {
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_service);
        editText=(EditText)findViewById(R.id.editText);
    }

    public void startService(View view) {
        Intent intent=new Intent(this,MyService.class);
        intent.putExtra("x",Double.parseDouble(editText.getText().toString()));
        startService(intent);
    }

    public void stopService(View view) {
        Intent intent=new Intent(this,MyService.class);
        stopService(intent);
    }
}
