package com.amaap.merchantsguide.domain.model.entity;

public class Metal {

    private int id;
    private String metalName;
    private int credits;

    public Metal(String metalName, int credits) {
        this.metalName = metalName;
        this.credits = credits;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMetalName() {
        return metalName;
    }

    public void setMetalName(String metalName) {
        this.metalName = metalName;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }
}
