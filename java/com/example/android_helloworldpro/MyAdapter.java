package com.example.android_helloworldpro;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter{
    ArrayList<Player> players;
    Context context;

    public MyAdapter(ArrayList<Player> players, Context context) {
        this.players = players;
        this.context = context;
    }

    @Override
    public int getCount() {
        return players.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView;
        if(convertView == null){
            textView=new TextView(context);
            textView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            textView.setTextSize(28);
        }else
            textView=(TextView) convertView;
        textView.setText(players.get(position).getName());
        return textView;
    }
}
