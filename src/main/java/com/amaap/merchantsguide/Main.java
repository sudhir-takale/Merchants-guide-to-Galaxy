package com.amaap.merchantsguide;

import com.amaap.merchantsguide.controller.GalacticTradeController;
import com.amaap.merchantsguide.repository.GalacticTradeRepository;
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
        GalacticTradeRepository galacticTradeRepository = new GalacticTradeRepositoryImpl(database);
        MetalService metalService = new MetalService(new MetalRepository(database));
        GalacticTradeService galacticTradeService = new GalacticTradeService(galacticTradeRepository, metalService);
        GalacticTradeController controller = new GalacticTradeController(galacticTradeService);

        GalacticTranslationService galacticTranslationService = new GalacticTranslationService(new GalacticTranslationRepository(database));
        FileProcessingService fileProcessingService = new FileProcessingService(galacticTradeService, galacticTranslationService);


        fileProcessingService.processInputFile("D:\\Tasks\\Merchant-Guide\\src\\main\\java\\com\\amaap\\merchantsguide\\resources\\GalacticTransactions.txt");
        controller.processQueries();

    }
}
