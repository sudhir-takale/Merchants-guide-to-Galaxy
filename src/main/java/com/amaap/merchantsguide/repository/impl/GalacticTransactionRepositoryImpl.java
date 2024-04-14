package com.amaap.merchantsguide.repository.impl;

import com.amaap.merchantsguide.domain.model.entity.GalacticTransaction;
import com.amaap.merchantsguide.repository.GalacticTransactionRepository;

import java.util.List;

public class GalacticTransactionRepositoryImpl implements GalacticTransactionRepository {
    @Override
    public int saveTransaction(GalacticTransaction galacticTransaction) {
        return 1;
    }

    @Override
    public List<GalacticTransaction> getTransactions() {
        return List.of();
    }
}
