package com.example.android_helloworldpro.chapter9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.android_helloworldpro.R;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SharedPreferencesActivity extends AppCompatActivity {
    private TextView read;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);
        read=(TextView)findViewById(R.id.read);
        preferences=getSharedPreferences("chapter9", Context.MODE_PRIVATE);
        editor=preferences.edit();

    }

    public void write(View view) {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日 hh：mm：ss");
        editor.putString("time",sdf.format(new Date()));
        editor.putInt("random", (int) (Math.random()*100));
        editor.commit();
    }

    public void read(View view) {
        String time=preferences.getString("time",null);
        int random=preferences.getInt("random",0);
        read.setText("time: "+time+"\n random: "+random);
    }
}
