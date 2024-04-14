package com.amaap.merchantsguide.service;

import com.amaap.merchantsguide.repository.FileRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

class FileProcessingServiceTest {


    @Test
    void shouldBeAbleToProcessInputFile() throws IOException {
        // arrange
        FileProcessingService fileProcessingService = new FileProcessingService(new FileRepository(), new GalacticTransactionService());

        // act
        boolean result = fileProcessingService.processInputFile("D:\\Tasks\\Merchant-Guide\\src\\test\\java\\com\\amaap\\merchantsguide\\resources\\GalacticTransactions.txt");

        // assert
        Assertions.assertTrue(result);

    }

}