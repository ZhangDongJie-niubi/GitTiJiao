package com.example.qimojineng03;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Foods {
private String Url;

@Generated(hash = 1193366574)
public Foods(String Url) {
	this.Url = Url;
}

@Generated(hash = 1839050448)
public Foods() {
}

public String getUrl() {
	return this.Url;
}

public void setUrl(String Url) {
	this.Url = Url;
}

}
