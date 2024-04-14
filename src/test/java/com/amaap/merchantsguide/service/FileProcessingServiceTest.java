package com.amaap.merchantsguide.service;

import com.amaap.merchantsguide.repository.FileRepository;
import com.amaap.merchantsguide.service.exception.InvalidFilePathNotExist;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.when;

class FileProcessingServiceTest {

    FileProcessingService fileProcessingService = new FileProcessingService(new FileRepository(), new GalacticTransactionService());

    @Test
    void shouldBeAbleToProcessInputFile() throws IOException, InvalidFilePathNotExist {
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