package com.example.zhoumozuoye4;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class Shu extends SQLiteOpenHelper {
    private Context basecontext;

    public Shu(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        basecontext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table biao(title varchar(200),chaptername varchar(200))");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void add(String title, String chaptername) {
        Shu shu = new Shu(basecontext, "ku.db", null, 1);
        SQLiteDatabase sql = shu.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("title", title);
        values.put("chaptername", chaptername);
        sql.insert("biao", null, values);
        sql.close();
    }

    public List<ShuL> cha() {
        List<ShuL> arr = new ArrayList<>();
        Shu shu = new Shu(basecontext, "ku.db", null, 1);
        SQLiteDatabase sql = shu.getWritableDatabase();
        Cursor biao = sql.query("biao", null, null, null, null, null, null);
        while (biao.moveToNext()) {
            String title = biao.getString(biao.getColumnIndex("title"));
            String chaptername = biao.getString(biao.getColumnIndex("chaptername"));
            arr.add(new ShuL(title, chaptername));
        }
        return arr;
    }


}
