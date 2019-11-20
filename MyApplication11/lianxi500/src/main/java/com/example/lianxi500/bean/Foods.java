package com.example.lianxi500.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Foods {
    private String title;

    @Generated(hash = 1920940599)
    public Foods(String title) {
        this.title = title;
    }

    @Generated(hash = 1839050448)
    public Foods() {
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
}
