package bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Foods {
    @Id(autoincrement = true)
    private long id;
    private String url;

    @Generated(hash = 1822071264)
    public Foods(long id, String url) {
        this.id = id;
        this.url = url;
    }

    @Generated(hash = 1839050448)
    public Foods() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Foods{" +
                "id=" + id +
                ", url='" + url + '\'' +
                '}';
    }
}
