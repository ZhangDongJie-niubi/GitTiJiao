package com.example.zhoumozuoye4;

public class ShuL {
    private  String Title;
    private String Chaptername;

    public ShuL(String title, String chaptername) {
        Title = title;
        Chaptername = chaptername;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getChaptername() {
        return Chaptername;
    }

    public void setChaptername(String chaptername) {
        Chaptername = chaptername;
    }

    @Override
    public String toString() {
        return "ShuL{" +
                "Title='" + Title + '\'' +
                ", Chaptername='" + Chaptername + '\'' +
                '}';
    }
}
