package com.example.ce23;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Food {
    @Id(autoincrement = true)
    private long id;
    private String name;
    private String sex;
    @Generated(hash = 1905750200)
    public Food(long id, String name, String sex) {
        this.id = id;
        this.name = name;
        this.sex = sex;
    }
    @Generated(hash = 866324199)
    public Food(){}
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSex() {
        return this.sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
}

//package com.example.greendao;
//
//        import org.greenrobot.greendao.annotation.Entity;
//        import org.greenrobot.greendao.annotation.Id;
//        import org.greenrobot.greendao.annotation.Generated;
//
//@Entity
//public class Food {
//    @Id(autoincrement = true)
//    private long id;
//    private String name;
//    private String sex;
//    @Generated(hash = 1905750200)
//    public Food(long id, String name, String sex) {
//        this.id = id;
//        this.name = name;
//        this.sex = sex;
//    }
//    @Generated(hash = 866324199)
//    public Food() {
//    }
//    public long getId() {
//        return this.id;
//    }
//    public void setId(long id) {
//        this.id = id;
//    }
//    public String getName() {
//        return this.name;
//    }
//    public void setName(String name) {
//        this.name = name;
//    }
//    public String getSex() {
//        return this.sex;
//    }
//    public void setSex(String sex) {
//        this.sex = sex;
//    }
//
//}
