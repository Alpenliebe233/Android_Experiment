package com.example.android_helloworldpro.chapter9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.android_helloworldpro.R;

public class DatabaseActivity extends AppCompatActivity {
    private EditText et1;
    private EditText et2;
    private EditText show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);
        et1=(EditText)findViewById(R.id.et1);
        et2=(EditText)findViewById(R.id.et2);
        show=(EditText)findViewById(R.id.show);

    }

    public void addBook(View view) {
        String bookName=et1.getText().toString();
        String author=et2.getText().toString();
        ContentValues values=new ContentValues();
        values.put("bookName",bookName);
        values.put("author",author);
        DBHelper helper=new DBHelper(this);
        helper.insert(values);
    }

    public void queryBook(View view) {
        DBHelper helper=new DBHelper(this);
        use_curson();
        helper.close();
    }
    public void use_curson(){
        show.setText("");
        DBHelper helper=new DBHelper(this);
        Cursor cursor=helper.query();
        while (cursor.moveToNext()) {
            int id=cursor.getInt(0);
            String bookName=cursor.getString(1);
            String author=cursor.getString(2);
            show.append(id+"\t\t\t"+bookName+"\t\t\t"+author+"\n");

        }
    }
}
