package com.example.zhoumozuoye2;

public class ShuL {
    private String Title;
    private String ChapterName;

    public ShuL(String title, String chapterName) {
        Title = title;
        ChapterName = chapterName;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getChapterName() {
        return ChapterName;
    }

    public void setChapterName(String chapterName) {
        ChapterName = chapterName;
    }

    @Override
    public String toString() {
        return "ShuL{" +
                "Title='" + Title + '\'' +
                ", ChapterName='" + ChapterName + '\'' +
                '}';
    }
}
