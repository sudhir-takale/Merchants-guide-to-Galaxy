package com.amaap.merchantsguide.controller;

import com.amaap.merchantsguide.controller.dto.HttpStatus;
import com.amaap.merchantsguide.controller.dto.Response;
import com.amaap.merchantsguide.repository.FileRepository;
import com.amaap.merchantsguide.repository.db.InMemoryDatabaseImpl;
import com.amaap.merchantsguide.repository.impl.FileRepositoryImpl;
import com.amaap.merchantsguide.repository.impl.GalacticTransactionRepositoryImpl;
import com.amaap.merchantsguide.service.FileProcessingService;
import com.amaap.merchantsguide.service.GalacticTransactionService;
import com.amaap.merchantsguide.service.exception.InvalidFilePathNotExist;
import com.amaap.merchantsguide.service.exception.InvalidGalacticTransactionFound;
import com.amaap.merchantsguide.service.exception.InvalidParameterTypeException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class InputProcessingControllerTest {

    @Test
    void shouldBeAbleToReadInputFile() throws IOException, InvalidFilePathNotExist, InvalidParameterTypeException {
        // arrange
        InputProcessingController inputController =
                new InputProcessingController(new FileProcessingService(new FileRepositoryImpl(new InMemoryDatabaseImpl()),
                        new GalacticTransactionService(new GalacticTransactionRepositoryImpl(new InMemoryDatabaseImpl()))));
        Response expectedResponse = new Response(HttpStatus.OK, "File has been processed successfully!");

        // act
        Response actualResponse = inputController.readInputFile("D:\\Tasks\\Merchant-Guide\\src\\test\\java\\com\\amaap\\merchantsguide\\resources\\GalacticTransactions.txt");

        // assert
        Assertions.assertEquals(expectedResponse, actualResponse);


    }


}
