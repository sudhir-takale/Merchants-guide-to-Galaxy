package com.amaap.merchantsguide.controller;

import com.amaap.merchantsguide.controller.dto.HttpStatus;
import com.amaap.merchantsguide.controller.dto.Response;
import com.amaap.merchantsguide.domain.service.QueryProcessor;
import com.amaap.merchantsguide.repository.UserRepository;
import com.amaap.merchantsguide.repository.db.InMemoryDatabaseImpl;
import com.amaap.merchantsguide.repository.impl.GalacticTransactionRepositoryImpl;
import com.amaap.merchantsguide.service.GalacticTransactionService;
import com.amaap.merchantsguide.service.UserService;
import com.amaap.merchantsguide.service.dto.GalacticQueryDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class UserControllerTest {
    UserController userController =
           new UserController(new UserService(new GalacticTransactionService(new GalacticTransactionRepositoryImpl(new InMemoryDatabaseImpl())),new QueryProcessor(),
                   new UserRepository(new InMemoryDatabaseImpl())));
    @Test
    void shouldBeAbleToCreateUser() {
        // arrange
        Response expectedResponse = new Response(HttpStatus.OK, "User created");

        // act
        Response actualResponse = userController.create(new ArrayList<GalacticQueryDto>());

        // assert

        Assertions.assertEquals(expectedResponse, actualResponse);

    }


    @Test
    void shouldBeAbleToProcessTheQueries() {
        // arrange
        Response expectedResponse = new Response(HttpStatus.OK, "Query processed");

        // act
        Response actualResponse = userController.processQueries();

        // assert

        Assertions.assertEquals(expectedResponse, actualResponse);

    }

}
