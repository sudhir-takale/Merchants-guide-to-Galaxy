package com.amaap.merchantsguide.repository.impl;

import com.amaap.merchantsguide.domain.model.entity.GalacticTrade;
import com.amaap.merchantsguide.domain.model.entity.Metal;
import com.amaap.merchantsguide.domain.model.valueobject.GalacticTranslation;
import com.amaap.merchantsguide.repository.GalacticTradeRepository;
import com.amaap.merchantsguide.repository.db.InMemoryDatabase;
import com.amaap.merchantsguide.repository.dto.GalacticQueryDto;
import com.google.inject.Inject;

import java.util.List;

public class GalacticTradeRepositoryImpl implements GalacticTradeRepository {

    private final InMemoryDatabase inMemoryDatabase;

    @Inject
    public GalacticTradeRepositoryImpl(InMemoryDatabase inMemoryDatabase) {
        this.inMemoryDatabase = inMemoryDatabase;
    }

    @Override
    public int saveTransaction(GalacticTrade galacticTrade) {
        inMemoryDatabase.addTransaction(galacticTrade);
        return 1;
    }

    @Override
    public List<GalacticTrade> getTransactions() {
        return this.inMemoryDatabase.getTransactions();
    }

    @Override
    public List<GalacticQueryDto> getAllQueries() {
        return inMemoryDatabase.getQueryList();
    }

    @Override
    public List<GalacticTranslation> getTranslationDto() {
        return inMemoryDatabase.getAllTranslations();
    }

    @Override
    public void createQuery(String query) {
        GalacticQueryDto galacticQueryDto = new GalacticQueryDto(query);
        inMemoryDatabase.saveQuery(galacticQueryDto);
    }

    @Override
    public List<Metal> getMetals() {
        return this.inMemoryDatabase.getMetals();
    }
}
