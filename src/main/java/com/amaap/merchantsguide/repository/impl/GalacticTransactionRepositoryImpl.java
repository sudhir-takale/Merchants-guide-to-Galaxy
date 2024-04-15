package com.amaap.merchantsguide.repository.impl;

import com.amaap.merchantsguide.domain.model.entity.GalacticTransaction;
import com.amaap.merchantsguide.repository.GalacticTransactionRepository;
import com.amaap.merchantsguide.repository.db.InMemoryDatabase;
import com.amaap.merchantsguide.service.dto.GalacticQueryDto;
import com.amaap.merchantsguide.service.dto.GalacticTranslationDto;

import java.util.List;

public class GalacticTransactionRepositoryImpl implements GalacticTransactionRepository {

    private final InMemoryDatabase inMemoryDatabase;

    public GalacticTransactionRepositoryImpl(InMemoryDatabase inMemoryDatabase) {
        this.inMemoryDatabase = inMemoryDatabase;
    }

    @Override
    public int saveTransaction(GalacticTransaction galacticTransaction) {
        inMemoryDatabase.addTransaction(galacticTransaction);
        return 1;
    }

    @Override
    public List<GalacticTransaction> getTransactions() {
        return this.inMemoryDatabase.getTransactions();
    }

    @Override
    public List<GalacticQueryDto> getAllQueries() {
        return inMemoryDatabase.getQueryList();
    }

    @Override
    public List<GalacticTranslationDto> getTranslationDto() {
        return inMemoryDatabase.getAllTranslations();
    }
}
