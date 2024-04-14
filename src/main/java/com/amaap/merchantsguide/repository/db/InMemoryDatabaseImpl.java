package com.amaap.merchantsguide.repository.db;

import com.amaap.merchantsguide.domain.model.entity.GalacticTransaction;
import com.amaap.merchantsguide.service.dto.GalacticQueryDto;
import com.amaap.merchantsguide.service.dto.GalacticTokenDto;

import java.util.ArrayList;
import java.util.List;

public class InMemoryDatabaseImpl implements InMemoryDatabase {


    private List<GalacticTokenDto> galaxyTranslationList = new ArrayList<>();
    private List<GalacticQueryDto> galaxyQueryList = new ArrayList<>();
    private List<GalacticTransaction> transactionList = new ArrayList<>();

    @Override
    public void save(GalacticTokenDto token) {
        this.galaxyTranslationList.add(token);
    }

    @Override
    public void insert(GalacticQueryDto query) {
        this.galaxyQueryList.add(query);
    }

    @Override
    public List<GalacticQueryDto> getQueryList() {
        return this.galaxyQueryList;
    }

    @Override
    public List<GalacticTokenDto> getAllTranslations() {
        return this.galaxyTranslationList;
    }

    @Override
    public List<GalacticTransaction> getTransactions() {
        return this.transactionList;
    }

    @Override
    public void addTransaction(GalacticTransaction galacticTransaction) {
        this.transactionList.add(galacticTransaction);
    }


}
