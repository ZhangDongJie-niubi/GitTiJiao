package bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Daobean {
    @Id(autoincrement = true)
    private long Id;
    private String Desc;
    private String EnvelopePic;
    @Generated(hash = 1257954372)
    public Daobean(long Id, String Desc, String EnvelopePic) {
        this.Id = Id;
        this.Desc = Desc;
        this.EnvelopePic = EnvelopePic;
    }
    @Generated(hash = 1831228405)
    public Daobean() {
    }
    public long getId() {
        return this.Id;
    }
    public void setId(long Id) {
        this.Id = Id;
    }
    public String getDesc() {
        return this.Desc;
    }
    public void setDesc(String Desc) {
        this.Desc = Desc;
    }
    public String getEnvelopePic() {
        return this.EnvelopePic;
    }
    public void setEnvelopePic(String EnvelopePic) {
        this.EnvelopePic = EnvelopePic;
    }
    
}
