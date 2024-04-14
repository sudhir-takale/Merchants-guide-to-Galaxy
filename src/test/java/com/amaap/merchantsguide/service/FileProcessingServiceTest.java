package com.amaap.merchantsguide.service;

import com.amaap.merchantsguide.repository.db.InMemoryDatabaseImpl;
import com.amaap.merchantsguide.repository.impl.FileRepositoryImpl;
import com.amaap.merchantsguide.repository.impl.GalacticTransactionRepositoryImpl;
import com.amaap.merchantsguide.service.exception.InValidMetalFoundException;
import com.amaap.merchantsguide.service.exception.InvalidFilePathNotExist;
import com.amaap.merchantsguide.service.exception.InvalidGalacticTransactionUnitException;
import com.amaap.merchantsguide.service.exception.InvalidParameterTypeException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;


class FileProcessingServiceTest {

    FileProcessingService fileProcessingService =
            new FileProcessingService(new FileRepositoryImpl(new InMemoryDatabaseImpl()),
                    new GalacticTransactionService(new GalacticTransactionRepositoryImpl()));

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
        Assertions.assertThrows(InvalidFilePathNotExist.class, () -> fileProcessingService.processInputFile(""));
    }

    @Test
    void shouldThrowExceptionWhenInvalidInputLinePassed() {
        // arrange
        String line = "Not is Not";
        // act & assert
        Assertions.assertThrows(InvalidGalacticTransactionUnitException.class, () -> fileProcessingService.parseInputLine(line));
    }

    @Test
    void shouldThrowExceptionWhenInvalidMetalInInputLinePassed() {
        // arrange
        String line = "pish pish Platinum is 3910 Credits";
        // act & assert
        Assertions.assertThrows(InValidMetalFoundException.class, () -> fileProcessingService.parseInputLine(line));
    }

    @Test
    void shouldThrowExceptionWhenInvalidTranslationPassed() {
        // arrange
        String line = "pish is H";
        // act & assert
        Assertions.assertThrows(InvalidParameterTypeException.class, () -> fileProcessingService.parseInputLine(line));
        Assertions.assertThrows(InvalidParameterTypeException.class, () -> fileProcessingService.parseInputLine("pish" +
                " pish Platinum is -3910 Credits"));
    }


}