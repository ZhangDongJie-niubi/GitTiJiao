package com.example.zhoukao;

public class ShuL {
    private String title;
    private String collect_num;
    private String pic;

    public ShuL(String title, String collect_num, String pic) {
        this.title = title;
        this.collect_num = collect_num;
        this.pic = pic;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCollect_num() {
        return collect_num;
    }

    public void setCollect_num(String collect_num) {
        this.collect_num = collect_num;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}
