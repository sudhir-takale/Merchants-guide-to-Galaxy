package com.amaap.merchantsguide.service;

import com.amaap.merchantsguide.domain.model.entity.GalacticTrade;
import com.amaap.merchantsguide.repository.GalacticTradeRepository;
import com.amaap.merchantsguide.repository.GalacticTranslationRepository;
import com.amaap.merchantsguide.repository.MetalRepository;
import com.amaap.merchantsguide.repository.db.InMemoryDatabase;
import com.amaap.merchantsguide.repository.db.InMemoryDatabaseImpl;
import com.amaap.merchantsguide.repository.impl.GalacticTradeRepositoryImpl;
import com.amaap.merchantsguide.service.exception.InvalidGalacticTransactionFound;
import com.amaap.merchantsguide.service.exception.InvalidParameterTypeException;
import com.amaap.merchantsguide.service.io.FileProcessingService;
import com.amaap.merchantsguide.service.io.exception.InvalidFilePathNotExist;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

class GalacticTradeServiceTest {
    InMemoryDatabase database = new InMemoryDatabaseImpl();
    GalacticTranslationRepository galacticTranslationRepository = new GalacticTranslationRepository(database);
    GalacticTranslationService galacticTranslationService = new GalacticTranslationService(galacticTranslationRepository);
    MetalRepository metalRepository = new MetalRepository(database);
    MetalService metalService = new MetalService(metalRepository);
    GalacticTradeRepository tradeRepository = new GalacticTradeRepositoryImpl(database);
    GalacticTradeService galacticTradeService = new GalacticTradeService(tradeRepository, metalService);
    FileProcessingService fileProcessingService = new FileProcessingService(galacticTradeService, galacticTranslationService);


    @Test
    void shouldBeAbleToCreateANewGalacticTransaction() throws InvalidGalacticTransactionFound {
        // arrange
        String unit = "glob glob";
        String metal = "Silver";
        int credits = 3910;

        // act
        boolean result = galacticTradeService.createTransaction(unit, metal, credits);

        // assert
        Assertions.assertTrue(result);
    }

    @Test
    void shouldBeAbleToFetchAllTransactions() throws InvalidGalacticTransactionFound {
        // arrange
        String unit = "glob glob";
        String metal = "Silver";
        int credits = 3910;
        galacticTradeService.createTransaction(unit, metal, credits);

        // act
        List<GalacticTrade> result = galacticTradeService.fetchTransactions();

        // assert
        Assertions.assertNotNull(result);
//        Assertions.assertEquals(4, result.size());

    }

    @Test
    void shouldThrowExceptionWhenInvalidMetalIsPassed() {
        // act & assert
        Assertions.assertThrows(InvalidGalacticTransactionFound.class, () -> galacticTradeService.createTransaction("prok prok", "", 34));

        Assertions.assertThrows(InvalidGalacticTransactionFound.class, () -> galacticTradeService.createTransaction("", "", 34));

        Assertions.assertThrows(InvalidGalacticTransactionFound.class, () -> galacticTradeService.createTransaction("prok prok", "Silver", -34));
    }


    @Test
    void shouldBeAbleToProcessAllQueries() throws InvalidParameterTypeException, InvalidFilePathNotExist, IOException {

        fileProcessingService.processInputFile("D:\\Tasks\\Merchant-Guide\\src\\main\\java\\com\\amaap" +
                "\\merchantsguide\\resources\\GalacticTransactions.txt");

        galacticTradeService.processQuery();

    }


}