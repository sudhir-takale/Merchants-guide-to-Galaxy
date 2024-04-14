package com.amaap.merchantsguide.service;

import com.amaap.merchantsguide.domain.model.entity.GalacticTransaction;

import java.util.ArrayList;
import java.util.List;

public class GalacticTransactionService {

    public boolean createTransaction(String unit, String metal, int credits) {
        GalacticTransaction galacticTransaction = new GalacticTransaction(unit, metal, credits);
        return galacticTransaction != null;
    }

    public List<GalacticTransaction> fetchTransactions() {
        return new ArrayList<>();
    }
}
