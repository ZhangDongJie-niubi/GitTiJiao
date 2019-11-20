package com.example.zhoukao;

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
        context = basecontext;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table biao(title varchar(200),collect_num varchar(200),pic varchar(200))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void add(String title, String collect_num, String pic) {
        Shu shu = new Shu(basecontext, "ku.db", null, 1);
        SQLiteDatabase sql = shu.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("title", title);
        values.put("collect_num", collect_num);
        values.put("pic", pic);
        sql.insert("biao", null, values);
    }

//    public List<ShuL> cha() {
//        Shu shu = new Shu(basecontext, "ku.db", null, 1);
//        SQLiteDatabase sql = shu.getWritableDatabase();
//        Cursor biao = sql.query("biao", null, null, null, null, null, null);
//        List<ShuL> arr = new ArrayList<>();
//        while (biao.moveToNext()) {
//            String title = biao.getString(biao.getColumnIndex("title"));
//            String collect_num = biao.getString(biao.getColumnIndex("collect_num"));
//            String pic = biao.getString(biao.getColumnIndex("pic"));
//            arr.add(new ShuL(title, collect_num, pic));
//        }
//        return arr;
//    }
}
