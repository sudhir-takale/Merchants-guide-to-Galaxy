package com.amaap.merchantsguide.controller;

import com.amaap.merchantsguide.controller.dto.HttpStatus;
import com.amaap.merchantsguide.controller.dto.Response;
import com.amaap.merchantsguide.repository.GalacticTradeRepository;
import com.amaap.merchantsguide.repository.GalacticTranslationRepository;
import com.amaap.merchantsguide.repository.MetalRepository;
import com.amaap.merchantsguide.repository.db.InMemoryDatabaseImpl;
import com.amaap.merchantsguide.repository.impl.GalacticTradeRepositoryImpl;
import com.amaap.merchantsguide.service.GalacticTradeService;
import com.amaap.merchantsguide.service.GalacticTranslationService;
import com.amaap.merchantsguide.service.MetalService;
import com.amaap.merchantsguide.service.io.FileProcessingService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GalacticTradeControllerTest {

    InMemoryDatabaseImpl database = new InMemoryDatabaseImpl();
    GalacticTradeRepository repository = new GalacticTradeRepositoryImpl(database);
    GalacticTradeService galacticTradeService = new GalacticTradeService(repository,
            new MetalService(new MetalRepository(new InMemoryDatabaseImpl())));

    GalacticTranslationService translationService =
            new GalacticTranslationService(new GalacticTranslationRepository(new InMemoryDatabaseImpl()));
    GalacticTransactionController galacticTransactionController = new GalacticTransactionController(galacticTradeService);
    FileProcessingService fileProcessingService = new FileProcessingService(galacticTradeService, translationService);

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
