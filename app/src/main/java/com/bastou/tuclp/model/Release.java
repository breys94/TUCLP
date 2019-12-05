package com.bastou.tuclp.model;

public class Release {

    private String pays;
    private String date;

    public Release(String pays, String date) {
        this.pays = pays;
        this.date = date;
    }

    public String getPays() {
        return pays;
    }

    public String getDate() {
        return date;
    }
}
