package com.amaap.merchantsguide.controller;

import com.amaap.merchantsguide.controller.dto.HttpStatus;
import com.amaap.merchantsguide.controller.dto.Response;
import com.amaap.merchantsguide.repository.GalacticTransactionRepository;
import com.amaap.merchantsguide.repository.db.InMemoryDatabaseImpl;
import com.amaap.merchantsguide.repository.impl.FileRepositoryImpl;
import com.amaap.merchantsguide.repository.impl.GalacticTransactionRepositoryImpl;
import com.amaap.merchantsguide.service.io.FileProcessingService;
import com.amaap.merchantsguide.service.GalacticTransactionService;
import com.amaap.merchantsguide.service.io.exception.InvalidFilePathNotExist;
import com.amaap.merchantsguide.service.exception.InvalidParameterTypeException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class GalacticTransactionControllerTest {

    InMemoryDatabaseImpl database = new InMemoryDatabaseImpl();
    GalacticTransactionRepository repository = new GalacticTransactionRepositoryImpl(database);
    GalacticTransactionService galacticTransactionService = new GalacticTransactionService(repository);

    GalacticTransactionController galacticTransactionController = new GalacticTransactionController(galacticTransactionService);


    FileRepositoryImpl fileRepository = new FileRepositoryImpl(database);
    FileProcessingService fileProcessingService = new FileProcessingService(fileRepository, galacticTransactionService);


    @Test
    void shouldBeAbleToGetAllNewTransaction() {
        Response expected = new Response(HttpStatus.OK, "Transactions has been fetched successfully");

        // act
        Response actual = galacticTransactionController.fetchAllTransactions();

        // assert
        Assertions.assertEquals(expected, actual);

    }


//    @Test
//    void shouldBeAbleToResolveQueries() throws InvalidParameterTypeException, InvalidFilePathNotExist, IOException {
//        Response expected = new Response(HttpStatus.OK, "All queries resolved successfully");
//        fileProcessingService.processInputFile("D:\\Tasks\\Merchant-Guide\\src\\main\\java\\com\\amaap\\merchantsguide\\resources" +
//                "\\GalacticTransactions.txt");
//
//        // act
//        Response actual = galacticTransactionController.processQueries();
//
//        // assert
//        Assertions.assertEquals(expected, actual);
//    }


}
