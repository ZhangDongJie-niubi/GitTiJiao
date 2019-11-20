package com.example.zhoumozuoye2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class Shu extends SQLiteOpenHelper {
private Context basecontext;
    public Shu(Context context, String name,SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        basecontext=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
      db.execSQL("create table biao(title varchar(200),chaptername varchar(200))");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void add(String title,String chaptevame){
        Shu shu = new Shu(basecontext,"ku.db",null,1);
        SQLiteDatabase sql = shu.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("title",title);
        values.put("chaptevame",chaptevame);
        sql.insert("biao",null,values);
        sql.close();
    }
    public List<ShuL> cha(){
        Shu shu = new Shu(basecontext,"ku.db",null,1);
        SQLiteDatabase sql = shu.getWritableDatabase();
        List<ShuL> arr = new ArrayList<>();
        Cursor biao = sql.query("biao", null, null, null, null, null, null);
        while(biao.moveToLast()){
            String title = biao.getString(biao.getColumnIndex("title"));
            String chaptevame = biao.getString(biao.getColumnIndex("chaptevame"));

            arr.add(new ShuL(title,chaptevame));
        }
          return arr;
    }
}
