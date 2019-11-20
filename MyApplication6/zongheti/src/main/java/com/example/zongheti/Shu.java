package com.example.zongheti;

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

    // ((RecycleViewHolder) viewHolder).tv5.setText(datasBean.getTitle());
// ((RecycleViewHolder) viewHolder).tv6.setText(datasBean.getChapterName());
// Glide.with(context).load(datasBean.getEnvelopePic()).into(((RecycleViewHolder) viewHolder).iv5);
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table biao(Title varchar(200),ChapterName varchar(200),EnvelopePic varchar(200))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void add(String title, String chaptername, String envelopepic) {
        Shu shu = new Shu(basecontext, "ku.db", null, 1);
        SQLiteDatabase sql = shu.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("title", title);
        values.put("chaptername", chaptername);
        values.put("envelopepic", envelopepic);
        sql.insert("biao", null, values);
    }

    public List<ShuL> cha() {
        Shu shu = new Shu(basecontext, "ku.db", null, 1);
        SQLiteDatabase sql = shu.getWritableDatabase();
        Cursor query = sql.query("biao", null, null, null, null, null, null);
        List<ShuL> arr = new ArrayList<>();
        while (query.moveToNext()) {
            String title = query.getString(query.getColumnIndex("title"));
            String chapterName = query.getString(query.getColumnIndex("chaptername"));
            String envelopePic = query.getString(query.getColumnIndex("envelopepic"));
            arr.add(new ShuL(title, chapterName, envelopePic));
        }
        return arr;
    }
}
