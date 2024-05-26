package com.amaap.merchantsguide.domain.model.entity;

public class GalacticTrade {


    private int id;
    private final String name;
    private final String metal;
    private final int credit;

    public GalacticTrade(String name, String metal, int credit) {
        this.name = name;
        this.metal = metal;
        this.credit = credit;
    }

    public int getCredit() {
        return credit;
    }

    public String getMetal() {
        return metal;
    }

    public int getTransactionId() {
        return id;
    }

    public void setTransactionId(int id) {
        this.id = id;
    }

    public String getTransactionName() {
        return name;
    }
}

