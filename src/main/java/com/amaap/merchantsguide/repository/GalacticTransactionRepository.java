package com.amaap.merchantsguide.repository;

import com.amaap.merchantsguide.domain.model.entity.GalacticTransaction;

import java.util.List;

public interface GalacticTransactionRepository {
    int saveTransaction(GalacticTransaction galacticTransaction);

    List<GalacticTransaction> getTransactions();
}
