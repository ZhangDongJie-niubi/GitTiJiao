package com.example.shujuku;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Food {
    private String name;
    private String age;

    @Generated(hash = 771752590)
    public Food(String name, String age) {
        this.name = name;
        this.age = age;
    }

    @Generated(hash = 866324199)
    public Food() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return this.age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
