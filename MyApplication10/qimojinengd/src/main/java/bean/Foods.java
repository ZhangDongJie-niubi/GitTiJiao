package bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Foods {
    @Id(autoincrement = true)
    private long id;
    private String Desc;
    private String ChapterName;
    @Generated(hash = 769010191)
    public Foods(long id, String Desc, String ChapterName) {
        this.id = id;
        this.Desc = Desc;
        this.ChapterName = ChapterName;
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
    public String getDesc() {
        return this.Desc;
    }
    public void setDesc(String Desc) {
        this.Desc = Desc;
    }
    public String getChapterName() {
        return this.ChapterName;
    }
    public void setChapterName(String ChapterName) {
        this.ChapterName = ChapterName;
    }

    @Override
    public String toString() {
        return "Foods{" +
                "id=" + id +
                ", Desc='" + Desc + '\'' +
                ", ChapterName='" + ChapterName + '\'' +
                '}';
    }
}
