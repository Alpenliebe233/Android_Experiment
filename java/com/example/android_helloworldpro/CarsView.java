package com.example.android_helloworldpro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class CarsView extends AppCompatActivity {

    ListView listView;
    TextView textView;
    ImageView imageView;
    ArrayList<Player> players;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_cars_view);

        listView=(ListView)findViewById(R.id.list);
        textView=(TextView)findViewById(R.id.introduction);
        imageView=(ImageView)findViewById(R.id.pic);
        players=new ArrayList<Player>();

        players.add(new Player("梅西","136万","阿根廷",R.drawable.messi));
        players.add(new Player("格列兹曼","88万","法国",R.drawable.griezmann));
        players.add(new Player("C罗","110万","葡萄牙",R.drawable.cl));
        players.add(new Player("武磊","1.6万","中国",R.drawable.wulei));
        players.add(new Player("蒿俊闵","16万","中国",R.drawable.hjm));
        players.add(new Player("孙兴民","100万","韩国",R.drawable.son));
        players.add(new Player("克莱奥","1万","巴西",R.drawable.kro));

        listView.setAdapter(new MyAdapter(players,this));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Player player=players.get(position);
                imageView.setImageResource(player.getPic());
                textView.setText(player.getName()+"\n周薪:"+player.getPrice()+"\n国籍:"+player.getNation());
            }
        });
    }
}
