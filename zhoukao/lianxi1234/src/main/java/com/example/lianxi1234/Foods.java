package com.example.lianxi1234;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Foods {
    private String pic;
    private String title;
    @Generated(hash = 1100156753)
    public Foods(String pic, String title) {
        this.pic = pic;
        this.title = title;
    }
    @Generated(hash = 1839050448)
    public Foods() {
    }
    public String getPic() {
        return this.pic;
    }
    public void setPic(String pic) {
        this.pic = pic;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
}
