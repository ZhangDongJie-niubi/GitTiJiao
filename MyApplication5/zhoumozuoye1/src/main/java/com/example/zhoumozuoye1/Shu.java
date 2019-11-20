package com.example.zhoumozuoye1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import bean.Student;

public class Shu extends SQLiteOpenHelper {
    private Context basecontext;


    public Shu(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.basecontext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table stu(title varchar(200),chapterName vahrchar(200))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void Add(String title, String chapterName) {
        Shu shu = new Shu(basecontext, "stus.db", null, 1);
        SQLiteDatabase database = shu.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("title", title);
        contentValues.put("chapterName", chapterName);
        database.insert("stu", null, contentValues);
        database.close();
    }

    public List<Student> selectAll() {
        List<Student> lists = new ArrayList<>();
        Shu shu = new Shu(basecontext, "stus.db", null, 1);
        SQLiteDatabase database = shu.getWritableDatabase();
        Cursor query = database.query("stu", null, null, null, null, null, null);
        while (query.moveToNext()) {
            String title = query.getString(query.getColumnIndex("title"));
            String chapterName = query.getString(query.getColumnIndex("chapterName"));
            Student student = new Student(title, chapterName);
            lists.add(student);
        }
        return lists;
    }
}
