package com.example.qimojinengdd;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Foods {
    private String Desc;

    @Generated(hash = 1858075620)
    public Foods(String Desc) {
        this.Desc = Desc;
    }

    @Generated(hash = 1839050448)
    public Foods() {
    }

    public String getDesc() {
        return this.Desc;
    }

    public void setDesc(String Desc) {
        this.Desc = Desc;
    }

    @Override
    public String toString() {
        return "Foods{" +
                "Desc='" + Desc + '\'' +
                '}';
    }
}
