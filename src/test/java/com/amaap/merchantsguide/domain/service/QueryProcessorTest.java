package com.amaap.merchantsguide.domain.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class QueryProcessorTest {

    @Test
    void shouldGetCorrectConversionFromRomanToNumber() {
        //act
        int result = QueryProcessor.convertToNumber("IXXV");

        // assert
        Assertions.assertEquals(24, result);
    }



}