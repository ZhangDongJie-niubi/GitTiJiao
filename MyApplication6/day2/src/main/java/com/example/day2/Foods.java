package com.example.day2;

public class Foods {
    //stage_id=1&limit=20&page=1
    private String stage_id;
    private  String limit;
    private String page;

    public Foods() {
        this.stage_id = stage_id;
        this.limit = limit;
        this.page = page;
    }

    public String getStage_id() {
        return stage_id;
    }

    public void setStage_id(String stage_id) {
        this.stage_id = stage_id;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }
}
