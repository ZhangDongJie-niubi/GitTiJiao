package com.example.qimojineng1;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Food {
    private String neirong;

    @Generated(hash = 2051492980)
    public Food(String neirong) {
        this.neirong = neirong;
    }

    @Generated(hash = 866324199)
    public Food() {
    }

    public String getNeirong() {
        return this.neirong;
    }

    public void setNeirong(String neirong) {
        this.neirong = neirong;
    }
    
}
