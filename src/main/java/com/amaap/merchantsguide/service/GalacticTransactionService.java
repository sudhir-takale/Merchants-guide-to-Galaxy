package com.amaap.merchantsguide.service;

import com.amaap.merchantsguide.domain.model.entity.GalacticTransaction;
import com.amaap.merchantsguide.repository.GalacticTransactionRepository;

import java.util.List;

public class GalacticTransactionService {
    private GalacticTransactionRepository transactionRepository;

    public GalacticTransactionService(GalacticTransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public boolean createTransaction(String unit, String metal, int credits) {
        GalacticTransaction galacticTransaction = new GalacticTransaction(unit, metal, credits);
        return transactionRepository.saveTransaction(galacticTransaction)==1;
    }

    public List<GalacticTransaction> fetchTransactions() {
        return transactionRepository.getTransactions();
    }
}
