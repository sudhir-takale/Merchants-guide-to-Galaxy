package com.amaap.merchantsguide.service;

import com.amaap.merchantsguide.domain.model.entity.GalacticTrade;
import com.amaap.merchantsguide.repository.GalacticTradeRepository;
import com.amaap.merchantsguide.repository.GalacticTranslationRepositoryImpl;
import com.amaap.merchantsguide.repository.MetalRepositoryImpl;
import com.amaap.merchantsguide.repository.db.InMemoryDatabase;
import com.amaap.merchantsguide.repository.db.impl.FakeInMemoryDatabase;
import com.amaap.merchantsguide.repository.impl.GalacticTradeRepositoryImpl;
import com.amaap.merchantsguide.service.exception.InValidMetalFoundException;
import com.amaap.merchantsguide.service.exception.InvalidGalacticTransactionFound;
import com.amaap.merchantsguide.service.exception.InvalidParameterTypeException;
import com.amaap.merchantsguide.service.io.FileProcessingService;
import com.amaap.merchantsguide.service.io.exception.InvalidFilePathNotExist;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GalacticTradeServiceTest {
    InMemoryDatabase database = new FakeInMemoryDatabase();
    GalacticTranslationRepositoryImpl galacticTranslationRepositoryImpl = new GalacticTranslationRepositoryImpl(database);
    GalacticTranslationService galacticTranslationService = new GalacticTranslationService(galacticTranslationRepositoryImpl);
    MetalRepositoryImpl metalRepositoryImpl = new MetalRepositoryImpl(database);
    MetalService metalService = new MetalService(metalRepositoryImpl);
    GalacticTradeRepository tradeRepository = new GalacticTradeRepositoryImpl(database);
    GalacticTradeService galacticTradeService = new GalacticTradeService(tradeRepository, metalService);
    FileProcessingService fileProcessingService = new FileProcessingService(galacticTradeService, galacticTranslationService);


    @Test
    void shouldBeAbleToCreateANewGalacticTransaction() throws InValidMetalFoundException {
        // arrange
        String unit = "glob glob";
        String metal = "Silver";
        int credits = 3910;

        // act
        boolean result = galacticTradeService.createTransaction(unit, metal, credits);

        // assert
        assertTrue(result);
    }

    @Test
    void shouldBeAbleToFetchAllTransactions() throws InValidMetalFoundException {
        // arrange
        String unit = "glob glob";
        String metal = "Silver";
        int credits = 3910;
        galacticTradeService.createTransaction(unit, metal, credits);

        // act
        List<GalacticTrade> result = galacticTradeService.fetchTransactions();

        // assert
        assertNotNull(result);

    }

    @Test
    void shouldThrowExceptionWhenInvalidMetalIsPassed() {
        // act & assert
        assertThrows(InvalidGalacticTransactionFound.class, () -> galacticTradeService.createTransaction("prok prok", "", 34));

        assertThrows(InvalidGalacticTransactionFound.class, () -> galacticTradeService.createTransaction("", "", 34));

        assertThrows(InvalidGalacticTransactionFound.class, () -> galacticTradeService.createTransaction("prok prok", "Silver", -34));
    }


    @Test
    void shouldBeAbleToProcessAllQueries() throws InvalidParameterTypeException, InvalidFilePathNotExist, IOException {

        fileProcessingService.processInputFile("D:\\Tasks\\Merchant-Guide\\src\\main\\java\\resources\\GalacticTransactions.txt");

        galacticTradeService.processQuery();

    }


}