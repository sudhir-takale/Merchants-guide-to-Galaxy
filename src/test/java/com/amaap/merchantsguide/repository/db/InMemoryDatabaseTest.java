package com.amaap.merchantsguide.repository.db;

import com.amaap.merchantsguide.domain.model.entity.GalacticTrade;
import com.amaap.merchantsguide.domain.model.entity.Metal;
import com.amaap.merchantsguide.domain.model.valueobject.GalacticTranslation;
import com.amaap.merchantsguide.repository.db.impl.FakeInMemoryDatabase;
import com.amaap.merchantsguide.repository.dto.GalacticQueryDto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class InMemoryDatabaseTest {
    InMemoryDatabase inMemoryDatabase = new FakeInMemoryDatabase();

    @Test
    void shouldBeAbleToGetAllQueriesFromDatabase() {
        // arrange
        GalacticQueryDto queryDto = new GalacticQueryDto("posh posh posh 344");
        inMemoryDatabase.saveQuery(queryDto);
        inMemoryDatabase.saveQuery(new GalacticQueryDto("pish pish pish 343"));

        // act
        List<GalacticQueryDto> queryList = inMemoryDatabase.getQueryList();

        // assert
        assertEquals(2, queryList.size());
    }

    @Test
    void shouldBeAbleToGetAllTranslations() {
        // arrange
        inMemoryDatabase.saveTranslation(new GalacticTranslation("pish", 'V'));
        inMemoryDatabase.saveTranslation(new GalacticTranslation("tedj", 'I'));
        inMemoryDatabase.saveTranslation(new GalacticTranslation("posh", 'X'));

        // act
        List<GalacticTranslation> allTranslations = inMemoryDatabase.getAllTranslations();

        // assert
        assertEquals(3, allTranslations.size());

    }

    @Test
    void shouldBeAbleToGetAllTradesFromDatabase() {
        // arrange
        inMemoryDatabase.addTransaction(new GalacticTrade("Pish pish pish", "silver", 454));
        inMemoryDatabase.addTransaction(new GalacticTrade("Pish pish tedj", "Iron", 4344));

        // act
        List<GalacticTrade> transactions = inMemoryDatabase.getTransactions();

        // assert
        assertEquals(2, transactions.size());

    }

    @Test
    void shouldBeAbleToAddNewTradeIntoDatabase() {
        // arrange
        GalacticTrade galacticTrade = new GalacticTrade("Posh posh psosh", "Silver", 345);

        // act
        inMemoryDatabase.addTransaction(galacticTrade);
        List<GalacticTrade> transactions = inMemoryDatabase.getTransactions();

        // assert
        assertEquals(1, transactions.size());

    }

    @Test
    void shouldBeAbleToSaveMetalToDatabase() {
        // arrange
        Metal metal = new Metal("Silver", 345.3);

        // act
        inMemoryDatabase.saveMetal(metal);
        List<Metal> metals = inMemoryDatabase.getMetals();

        // assert
        assertTrue(metals.size() == 1);

    }

    @Test
    void shouldBeAbleToSaveQueryToDatabase() {
        // arrange
        GalacticQueryDto dto = new GalacticQueryDto("Posh posh");

        // act
        inMemoryDatabase.saveQuery(dto);
        List<GalacticQueryDto> queryList = inMemoryDatabase.getQueryList();

        // assert
        assertTrue(!queryList.isEmpty());
    }

    @Test
    void shouldBeAbleToSaveTranslationsToDatabase() {
        // arrange
        GalacticTranslation galacticTranslation = new GalacticTranslation("posh", 'v');

        // act
        inMemoryDatabase.saveTranslation(galacticTranslation);
        List<GalacticTranslation> allTranslations = inMemoryDatabase.getAllTranslations();

        // assert
        assertTrue(!allTranslations.isEmpty());

    }

    @Test
    void getMetals() {
        // arrange
        inMemoryDatabase.saveMetal(new Metal("Silver", 345));
        inMemoryDatabase.saveMetal(new Metal("Gold", 345));
        inMemoryDatabase.saveMetal(new Metal("Iron", 345));

        // act
        List<Metal> metals = inMemoryDatabase.getMetals();

        // assert
        assertEquals(3, metals.size());

    }
}