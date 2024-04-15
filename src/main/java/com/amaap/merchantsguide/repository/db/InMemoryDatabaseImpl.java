package com.amaap.merchantsguide.repository.db;

import com.amaap.merchantsguide.domain.model.entity.GalacticTrade;
import com.amaap.merchantsguide.domain.model.entity.Metal;
import com.amaap.merchantsguide.domain.model.valueobject.GalacticTranslation;
import com.amaap.merchantsguide.repository.dto.GalacticQueryDto;

import java.util.ArrayList;
import java.util.List;

public class InMemoryDatabaseImpl implements InMemoryDatabase {


    private List<GalacticTranslation> galaxyTranslationList = new ArrayList<>();
    private List<GalacticQueryDto> galaxyQueryList = new ArrayList<>();
    private List<GalacticTrade> transactionList = new ArrayList<>();
    private List<Metal> metals = new ArrayList<>();

    @Override
    public void save(GalacticTranslation token) {
        this.galaxyTranslationList.add(token);
    }


    @Override
    public List<GalacticQueryDto> getQueryList() {
        return this.galaxyQueryList;
    }

    @Override
    public List<GalacticTranslation> getAllTranslations() {
        return this.galaxyTranslationList;
    }

    @Override
    public List<GalacticTrade> getTransactions() {
        return this.transactionList;
    }

    @Override
    public void addTransaction(GalacticTrade galacticTrade) {
        this.transactionList.add(galacticTrade);
    }

    @Override
    public void saveMetal(Metal newMetal) {
        this.metals.add(newMetal);
    }

    @Override
    public void saveQuery(GalacticQueryDto query) {
        this.galaxyQueryList.add(query);
    }

}
