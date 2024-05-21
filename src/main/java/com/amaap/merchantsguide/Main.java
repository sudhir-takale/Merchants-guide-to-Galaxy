package com.amaap.merchantsguide;

import com.amaap.merchantsguide.controller.GalacticTradeController;
import com.amaap.merchantsguide.repository.impl.GalacticTranslationRepositoryImpl;
import com.amaap.merchantsguide.repository.impl.MetalRepositoryImpl;
import com.amaap.merchantsguide.repository.db.InMemoryDatabase;
import com.amaap.merchantsguide.repository.db.impl.FakeInMemoryDatabase;
import com.amaap.merchantsguide.repository.impl.GalacticTradeRepositoryImpl;
import com.amaap.merchantsguide.service.GalacticTradeService;
import com.amaap.merchantsguide.service.GalacticTranslationService;
import com.amaap.merchantsguide.service.MetalService;
import com.amaap.merchantsguide.service.exception.InvalidParameterTypeException;
import com.amaap.merchantsguide.service.io.FileProcessingService;
import com.amaap.merchantsguide.service.io.exception.InvalidFilePathNotExistException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws InvalidParameterTypeException, InvalidFilePathNotExistException, IOException {
        InMemoryDatabase database = new FakeInMemoryDatabase();
        GalacticTradeController controller = new GalacticTradeController(new GalacticTradeService(new GalacticTradeRepositoryImpl(database), new MetalService(new MetalRepositoryImpl(database))));
        FileProcessingService fileProcessingService = new FileProcessingService(new GalacticTradeService(new GalacticTradeRepositoryImpl(database), new MetalService(new MetalRepositoryImpl(database))), new GalacticTranslationService(new GalacticTranslationRepositoryImpl(database)));
        fileProcessingService.processInputFile("D:\\Tasks\\Merchant-Guide\\src\\main\\java\\resources\\GalacticTransactions.txt");
        controller.processQueries();

    }
}
