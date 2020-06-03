package com.example.android_helloworldpro.chapter9;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME="books.db";
    private static final String TBL_NAME="BookTbl";

    private SQLiteDatabase db;
    public DBHelper(Context c) {
        super(c, DB_NAME, null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db=db;
        String CREATE_TBL="create table BookTbl(id integer primary key autoincrement,bookname text,author text)";
        db.execSQL(CREATE_TBL);
    }
    public void insert(ContentValues values){
        SQLiteDatabase db=getWritableDatabase();
        db.insert(TBL_NAME,null,values);
        db.close();
    }

    public Cursor query(){
        SQLiteDatabase db=getReadableDatabase();
        Cursor c=db.query(TBL_NAME,null,null,null,null,null,null);
        return  c;
    }


    public void close(){
        if(db !=null)
            db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
