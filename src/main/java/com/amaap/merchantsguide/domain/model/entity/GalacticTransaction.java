package com.amaap.merchantsguide.domain.model.entity;

public class GalacticTransaction {

    private final String transactionName;
    private final String metal;
    private final int credit;
    private int transactionId;

    public GalacticTransaction(String transactionName, String metal, int credit) {
        this.transactionName = transactionName;
        this.metal = metal;
        this.credit = credit;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public int getCredit() {
        return credit;
    }
}
