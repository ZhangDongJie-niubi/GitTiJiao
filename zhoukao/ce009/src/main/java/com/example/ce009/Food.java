package com.example.ce009;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Food {
    private String url;
    private String name;
    private String desc;
    @Generated(hash = 1696074947)
    public Food(String url, String name, String desc) {
        this.url = url;
        this.name = name;
        this.desc = desc;
    }
    @Generated(hash = 866324199)
    public Food() {
    }
    public String getUrl() {
        return this.url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDesc() {
        return this.desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    
}

