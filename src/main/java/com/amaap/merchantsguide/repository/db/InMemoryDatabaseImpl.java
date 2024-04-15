package com.amaap.merchantsguide.repository.db;

import com.amaap.merchantsguide.domain.model.entity.GalacticTrade;
import com.amaap.merchantsguide.domain.model.entity.Metal;
import com.amaap.merchantsguide.domain.model.valueobject.GalacticTranslation;
import com.amaap.merchantsguide.repository.dto.GalacticQueryDto;

import java.util.ArrayList;
import java.util.List;

public class InMemoryDatabaseImpl implements InMemoryDatabase {


    private static List<GalacticTranslation> galaxyTranslationList = new ArrayList<>();
    private static List<GalacticQueryDto> galaxyQueryList = new ArrayList<>();
    private static List<GalacticTrade> transactionList = new ArrayList<>();
    private static List<Metal> metals = new ArrayList<>();


    static {

        galaxyTranslationList.add(new GalacticTranslation("glob", 'I'));
        galaxyTranslationList.add(new GalacticTranslation("prok", 'V'));
        galaxyTranslationList.add(new GalacticTranslation("pish", 'X'));
        galaxyTranslationList.add(new GalacticTranslation("tegj", 'L'));

        transactionList.add(new GalacticTrade("glob glob", "Silver", 34));
        transactionList.add(new GalacticTrade("glob prok", "Gold", 57800));
        transactionList.add(new GalacticTrade("pish pish", "Iron", 3910));

        galaxyQueryList.add(new GalacticQueryDto("glob prok Silver"));
        galaxyQueryList.add(new GalacticQueryDto("glob prok Gold"));
        galaxyQueryList.add(new GalacticQueryDto("glob prok Iron"));
        galaxyQueryList.add(new GalacticQueryDto("pish tegj glob glob"));
        galaxyQueryList.add(new GalacticQueryDto("This is invalid query that you are processing "));

        metals.add(new Metal("Silver", 17.0));
        metals.add(new Metal("Gold", 14450.0));
        metals.add(new Metal("Iron", 195.5));
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
        transactionList.add(galacticTrade);
    }

    @Override
    public void saveMetal(Metal newMetal) {
        metals.add(newMetal);
    }

    @Override
    public void saveQuery(GalacticQueryDto query) {
        galaxyQueryList.add(query);
    }

    @Override
    public void saveTranslation(GalacticTranslation galacticTranslation) {
        galaxyTranslationList.add(galacticTranslation);
    }

    @Override
    public List<Metal> getMetals() {
        return metals;
    }

}
