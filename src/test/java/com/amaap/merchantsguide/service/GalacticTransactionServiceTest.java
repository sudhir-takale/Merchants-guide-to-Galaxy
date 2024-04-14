package com.amaap.merchantsguide.service;

import com.amaap.merchantsguide.domain.model.entity.GalacticTransaction;
import com.amaap.merchantsguide.repository.db.InMemoryDatabaseImpl;
import com.amaap.merchantsguide.repository.impl.GalacticTransactionRepositoryImpl;
import com.amaap.merchantsguide.service.exception.InvalidGalacticTransactionFound;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class GalacticTransactionServiceTest {
    GalacticTransactionService galacticTransactionService =
            new GalacticTransactionService(new GalacticTransactionRepositoryImpl(new InMemoryDatabaseImpl()));


    @Test
    void shouldBeAbleToCreateANewGalacticTransaction() throws InvalidGalacticTransactionFound {
        // arrange
        String unit = "glob glob";
        String metal = "Silver";
        int credits = 3910;

        // act
        boolean result = galacticTransactionService.createTransaction(unit, metal, credits);

        // assert
        Assertions.assertTrue(result);
    }

    @Test
    void shouldBeAbleToFetchAllTransactions() throws InvalidGalacticTransactionFound {
        // arrange
        String unit = "glob glob";
        String metal = "Silver";
        int credits = 3910;
        galacticTransactionService.createTransaction(unit, metal, credits);

        // act
        List<GalacticTransaction> result = galacticTransactionService.fetchTransactions();

        // assert
        Assertions.assertEquals(1, result.size());

    }

    @Test
    void shouldThrowExceptionWhenInvalidMetalIsPassed() {
        // act & assert
        Assertions.assertThrows(InvalidGalacticTransactionFound.class,
                () -> galacticTransactionService.createTransaction("prok prok", "", 34));

        Assertions.assertThrows(InvalidGalacticTransactionFound.class,
                () -> galacticTransactionService.createTransaction("", "", 34));

        Assertions.assertThrows(InvalidGalacticTransactionFound.class,
                () -> galacticTransactionService.createTransaction("prok prok", "Silver", -34));
    }

}