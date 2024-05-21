package com.amaap.merchantsguide.domain.model.entity;

public class GalacticTrade {

    private int transactionId;
    private final String transactionName;
    private final String metal;
    private final int credit;

    public GalacticTrade(String transactionName, String metal, int credit) {
        this.transactionName = transactionName;
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
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionName() {
        return transactionName;
    }
}

