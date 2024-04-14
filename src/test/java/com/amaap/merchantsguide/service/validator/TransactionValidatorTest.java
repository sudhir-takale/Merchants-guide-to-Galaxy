package com.amaap.merchantsguide.service.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TransactionValidatorTest {

    TransactionValidator transactionValidator = new TransactionValidator();

    @Test
    void shouldBeAbleToCrateInstanceOfValidator() {
        // assert
        Assertions.assertNotNull(transactionValidator);
    }

    @Test
    void shouldReturnFalseWhenValidArgumentPassed() {
        // arrange
        String unit = "glob glob";
        String metal = "silver";
        int credits = 343;

        // act
        boolean result = TransactionValidator.validateTransaction(unit, metal, credits);

        // assert
        Assertions.assertFalse(result);

    }

    @Test
    void shouldReturnFalseWhenInvalidArgumentPassed() {
        // arrange
        String unit = "glob glob";
        String metal = "silver";
        int credits = -343;

        // act
        boolean result = TransactionValidator.validateTransaction(unit, metal, credits);

        // assert
        Assertions.assertTrue(result);
        Assertions.assertTrue(TransactionValidator.validateTransaction(unit, "", 4655));
        Assertions.assertTrue(TransactionValidator.validateTransaction("", metal, 4655));

    }

}