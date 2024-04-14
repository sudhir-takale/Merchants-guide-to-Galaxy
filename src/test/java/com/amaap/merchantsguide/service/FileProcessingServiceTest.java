package com.amaap.merchantsguide.service;

import com.amaap.merchantsguide.repository.db.InMemoryDatabaseImpl;
import com.amaap.merchantsguide.repository.impl.FileRepositoryImpl;
import com.amaap.merchantsguide.service.exception.InvalidFilePathNotExist;
import com.amaap.merchantsguide.service.exception.InvalidParameterTypeException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;


class FileProcessingServiceTest {

    FileProcessingService fileProcessingService = new FileProcessingService(new FileRepositoryImpl(new InMemoryDatabaseImpl()),
            new GalacticTransactionService());

    @Test
    void shouldBeAbleToProcessInputFile() throws IOException, InvalidFilePathNotExist, InvalidParameterTypeException {
        // act
        boolean result = fileProcessingService.processInputFile("D:\\Tasks\\Merchant-Guide\\src\\test\\java\\com\\amaap\\merchantsguide\\resources\\GalacticTransactions.txt");

        // assert
        Assertions.assertTrue(result);

    }

    @Test
    void shouldThrowExceptionIfFilePathNotExists() {
        // act & assert
        Assertions.assertThrows(InvalidFilePathNotExist.class , ()-> fileProcessingService.processInputFile(""));
    }






}