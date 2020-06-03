package com.example.android_helloworldpro;

import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.android_helloworldpro.chapter5.chapter5.Fragment.FragmentA;
import com.example.android_helloworldpro.chapter5.chapter5.Fragment.FragmentB;

public class FragmentActivity extends AppCompatActivity implements View.OnClickListener {

    public FragmentA fragA;
    public FragmentB fragB;

    public TextView fraga;
    public TextView fragb;

    public FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_activity);

        fragA=new FragmentA();
        fragB=new FragmentB();

        fraga=(TextView)findViewById(R.id.frag1);
        fragb=(TextView)findViewById(R.id.frag2);

        fragmentManager=getFragmentManager();


        fraga.setOnClickListener(this);
        fragb.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        switch (v.getId()) {
            case R.id.frag1:
                transaction.replace(R.id.textRight,fragA);
                transaction.addToBackStack(null);
                break;
            case R.id.frag2:
                transaction.replace(R.id.textRight,fragB);
                transaction.addToBackStack(null);
                break;
            default:
                break;
        }

        transaction.commit();
    }
}

