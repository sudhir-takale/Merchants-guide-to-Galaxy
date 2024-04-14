package com.amaap.merchantsguide.repository.impl;

import com.amaap.merchantsguide.domain.model.entity.GalacticTransaction;
import com.amaap.merchantsguide.repository.GalacticTransactionRepository;
import com.amaap.merchantsguide.repository.db.InMemoryDatabaseImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class GalacticTransactionRepositoryImplTest {

    GalacticTransactionRepository galacticTransactionRepository = new GalacticTransactionRepositoryImpl(new InMemoryDatabaseImpl());

    @Test
    void shouldBeAbleToSaveGalacticTransaction() {
        // arrange
        String unit = "glob glob";
        String metal = "Silver";
        int credits = 3910;
        GalacticTransaction galacticTransaction = new GalacticTransaction(unit, metal, credits);

        //act
        int result = galacticTransactionRepository.saveTransaction(galacticTransaction);

        // assert

        Assertions.assertEquals(1, result);

    }

    @Test
    void shouldBeAbleGetAllGalacticTransaction() {
        // arrange
        String unit = "glob glob";
        String metal = "Silver";
        int credits = 3910;
        GalacticTransaction galacticTransaction = new GalacticTransaction(unit, metal, credits);
        galacticTransactionRepository.saveTransaction(galacticTransaction);
        //act
        List<GalacticTransaction> result = galacticTransactionRepository.getTransactions();

        // assert
        Assertions.assertEquals(1, result.size());

    }


}