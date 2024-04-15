package com.amaap.merchantsguide.service;

import com.amaap.merchantsguide.domain.model.entity.GalacticTrade;
import com.amaap.merchantsguide.repository.db.InMemoryDatabaseImpl;
import com.amaap.merchantsguide.repository.impl.GalacticTradeRepositoryImpl;
import com.amaap.merchantsguide.service.exception.InvalidGalacticTransactionFound;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class GalacticTradeServiceTest {
    GalacticTradeService galacticTradeService = new GalacticTradeService(new GalacticTradeRepositoryImpl(new InMemoryDatabaseImpl()));


    @Test
    void shouldBeAbleToCreateANewGalacticTransaction() throws InvalidGalacticTransactionFound {
        // arrange
        String unit = "glob glob";
        String metal = "Silver";
        int credits = 3910;

        // act
        boolean result = galacticTradeService.createTransaction(unit, metal, credits);

        // assert
        Assertions.assertTrue(result);
    }

    @Test
    void shouldBeAbleToFetchAllTransactions() throws InvalidGalacticTransactionFound {
        // arrange
        String unit = "glob glob";
        String metal = "Silver";
        int credits = 3910;
        galacticTradeService.createTransaction(unit, metal, credits);

        // act
        List<GalacticTrade> result = galacticTradeService.fetchTransactions();

        // assert
        Assertions.assertEquals(1, result.size());

    }

    @Test
    void shouldThrowExceptionWhenInvalidMetalIsPassed() {
        // act & assert
        Assertions.assertThrows(InvalidGalacticTransactionFound.class, () -> galacticTradeService.createTransaction("prok prok", "", 34));

        Assertions.assertThrows(InvalidGalacticTransactionFound.class, () -> galacticTradeService.createTransaction("", "", 34));

        Assertions.assertThrows(InvalidGalacticTransactionFound.class, () -> galacticTradeService.createTransaction("prok prok", "Silver", -34));
    }




}