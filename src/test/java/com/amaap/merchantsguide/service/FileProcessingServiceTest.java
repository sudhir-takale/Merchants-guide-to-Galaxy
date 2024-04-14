package com.amaap.merchantsguide.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

class FileProcessingServiceTest {


    @Test
    void shouldBeAbleToProcessInputFile() throws FileNotFoundException {
        // arrange
        FileProcessingService fileProcessingService = new FileProcessingService();

        // act
        boolean result = fileProcessingService.processInputFile("D:\\Tasks\\Merchant-Guide\\src\\test\\java\\com\\amaap\\merchantsguide\\resources\\GalacticTransactions.txt");

        // assert
        Assertions.assertTrue(result);

    }

}