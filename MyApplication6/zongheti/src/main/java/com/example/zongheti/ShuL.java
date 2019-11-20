package com.example.zongheti;

public class ShuL {
    //      ((RecycleViewHolder) viewHolder).tv5.setText(datasBean.getTitle());
//            ((RecycleViewHolder) viewHolder).tv6.setText(datasBean.getChapterName());
//            Glide.with(context).load(datasBean.getEnvelopePic()).into(((RecycleViewHolder) viewHolder).iv5);
    private String title;
    private String chaptername;
    private String envelopepic;

    public ShuL(String title, String chaptername, String envelopepic) {
        this.title = title;
        this.chaptername = chaptername;
        this.envelopepic = envelopepic;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getChaptername() {
        return chaptername;
    }

    public void setChaptername(String chaptername) {
        this.chaptername = chaptername;
    }

    public String getEnvelopepic() {
        return envelopepic;
    }

    public void setEnvelopepic(String envelopepic) {
        this.envelopepic = envelopepic;
    }
}
