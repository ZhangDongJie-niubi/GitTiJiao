package bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Foods {
    private String url;
    private String title;
    @Generated(hash = 1144391658)
    public Foods(String url, String title) {
        this.url = url;
        this.title = title;
    }
    @Generated(hash = 1839050448)
    public Foods() {
    }
    public String getUrl() {
        return this.url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    
}
