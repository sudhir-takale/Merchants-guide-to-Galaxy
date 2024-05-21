package com.amaap.merchantsguide;

import com.amaap.merchantsguide.controller.GalacticTradeController;
import com.amaap.merchantsguide.controller.MerchantController;
import com.amaap.merchantsguide.service.exception.InvalidParameterTypeException;
import com.amaap.merchantsguide.service.io.exception.InvalidFilePathNotExistException;
import com.google.inject.Guice;
import com.google.inject.Injector;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws InvalidParameterTypeException, InvalidFilePathNotExistException, IOException {
        Injector injector = Guice.createInjector(new MerchantModule());
        MerchantController merchantController = injector.getInstance(MerchantController.class);
        merchantController.processFile("D:\\Tasks\\Merchant-Guide\\src\\main\\java\\resources\\GalacticTransactions.txt");
        GalacticTradeController galacticTradeController = injector.getInstance(GalacticTradeController.class);
        System.out.println(galacticTradeController.processQueries());
        System.out.println(galacticTradeController.fetchAllTransactions());
    }
}
