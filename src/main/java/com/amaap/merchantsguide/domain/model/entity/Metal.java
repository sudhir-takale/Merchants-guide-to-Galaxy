package com.amaap.merchantsguide.domain.model.entity;

public class Metal {

    private int id;
    private String metalName;
    private double credits;

    public Metal(String metalName, double credits) {
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

    public double getCredits() {
        return credits;
    }

    public void setCredits(double credits) {
        this.credits = credits;
    }
}
