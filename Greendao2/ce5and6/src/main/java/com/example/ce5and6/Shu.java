package com.example.ce5and6;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Shu extends SQLiteOpenHelper {
    private Context basecontext;

    public Shu(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        basecontext = context;

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table biao(id Integer,name varchar(200))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void add(int id, String name) {
        Shu shu = new Shu(basecontext, "ku.db", null, 1);
        SQLiteDatabase sql = shu.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id", id);
        values.put("name", name);
        sql.insert("biao", null, values);
        sql.close();
    }

    public List<Student> cha() {
        Shu shu = new Shu(basecontext, "ku.db", null, 1);
        SQLiteDatabase sql = shu.getWritableDatabase();
        List<Student> arr = new ArrayList<>();
        Cursor biao = sql.query("biao", null, null, null, null, null, null);
        while (biao.moveToNext()) {
            int id = biao.getInt(biao.getColumnIndex("id"));
            String name = biao.getString(biao.getColumnIndex("name"));
            arr.add(new Student(id, name));
        }
        return arr;
    }

    public void shan(int id) {
        Shu shu = new Shu(basecontext, "ku.db", null, 1);
        SQLiteDatabase sql = shu.getWritableDatabase();
        sql.delete("biao", "id=?", new String[]{id + ""});
        sql.close();
    }

    public void xiu(int id ,String name) {
        Shu shu = new Shu(basecontext, "ku.db", null, 1);
        SQLiteDatabase sql = shu.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id", id);
        values.put("name", name);
        String[] strings = {name + ""};
        sql.update("biao", values, "id=?", strings);
        sql.close();
    }
}
