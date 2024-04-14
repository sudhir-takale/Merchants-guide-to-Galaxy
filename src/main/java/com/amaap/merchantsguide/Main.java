package com.amaap.merchantsguide;

import com.amaap.merchantsguide.controller.InputProcessingController;
import com.amaap.merchantsguide.controller.UserController;
import com.amaap.merchantsguide.domain.service.QueryProcessor;
import com.amaap.merchantsguide.repository.UserRepository;
import com.amaap.merchantsguide.repository.db.InMemoryDatabaseImpl;
import com.amaap.merchantsguide.repository.impl.FileRepositoryImpl;
import com.amaap.merchantsguide.repository.impl.GalacticTransactionRepositoryImpl;
import com.amaap.merchantsguide.service.FileProcessingService;
import com.amaap.merchantsguide.service.GalacticTransactionService;
import com.amaap.merchantsguide.service.UserService;
import com.amaap.merchantsguide.service.exception.InvalidFilePathNotExist;
import com.amaap.merchantsguide.service.exception.InvalidParameterTypeException;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws InvalidParameterTypeException, InvalidFilePathNotExist, IOException {

        InputProcessingController inputController = new InputProcessingController(new FileProcessingService(new FileRepositoryImpl(new InMemoryDatabaseImpl()), new GalacticTransactionService(new GalacticTransactionRepositoryImpl(new InMemoryDatabaseImpl()))));

        inputController.readInputFile("D:\\Tasks\\Merchant-Guide\\src\\test\\java\\com\\amaap\\merchantsguide" +
                "\\resources\\GalacticTransactions.txt");

        UserController userController =
                new UserController(new UserService(new GalacticTransactionService(new GalacticTransactionRepositoryImpl(new InMemoryDatabaseImpl())),new QueryProcessor(),
                        new UserRepository(new InMemoryDatabaseImpl())));


        userController.processQueries();


    }
}
