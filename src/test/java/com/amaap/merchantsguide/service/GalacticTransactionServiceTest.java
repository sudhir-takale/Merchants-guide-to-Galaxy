package com.amaap.merchantsguide.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GalacticTransactionServiceTest {
    GalacticTransactionService galacticTransactionService = new GalacticTransactionService();


    @Test
    void shouldBeAbleToCreateANewGalacticTransaction() {
        // arrange
        String unit = "glob glob";
        String metal = "Silver";
        int credits = 3910;

        // act
        boolean result = galacticTransactionService.createTransaction(unit, metal, credits);

        // assert
        Assertions.assertTrue(result);
    }


}