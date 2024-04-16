package com.amaap.merchantsguide;

import com.amaap.merchantsguide.controller.GalacticTradeController;
import com.amaap.merchantsguide.repository.GalacticTranslationRepository;
import com.amaap.merchantsguide.repository.MetalRepository;
import com.amaap.merchantsguide.repository.db.InMemoryDatabase;
import com.amaap.merchantsguide.repository.db.InMemoryDatabaseImpl;
import com.amaap.merchantsguide.repository.impl.GalacticTradeRepositoryImpl;
import com.amaap.merchantsguide.service.GalacticTradeService;
import com.amaap.merchantsguide.service.GalacticTranslationService;
import com.amaap.merchantsguide.service.MetalService;
import com.amaap.merchantsguide.service.exception.InvalidParameterTypeException;
import com.amaap.merchantsguide.service.io.FileProcessingService;
import com.amaap.merchantsguide.service.io.exception.InvalidFilePathNotExist;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws InvalidParameterTypeException, InvalidFilePathNotExist, IOException {
        InMemoryDatabase database = new InMemoryDatabaseImpl();
        GalacticTradeController controller =
                new GalacticTradeController(new GalacticTradeService(new GalacticTradeRepositoryImpl(database),
                        new MetalService(new MetalRepository(database))));
        FileProcessingService fileProcessingService = new FileProcessingService(new GalacticTradeService(new GalacticTradeRepositoryImpl(database), new MetalService(new MetalRepository(database))), new GalacticTranslationService(new GalacticTranslationRepository(database)));


        fileProcessingService.processInputFile("D:\\Tasks\\Merchant-Guide\\src\\main\\java\\com\\amaap\\merchantsguide\\resources\\GalacticTransactions.txt");
        controller.processQueries();

    }
}
