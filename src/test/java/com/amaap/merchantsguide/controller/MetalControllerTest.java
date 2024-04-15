package com.amaap.merchantsguide.controller;

import com.amaap.merchantsguide.repository.MetalRepository;
import com.amaap.merchantsguide.repository.db.InMemoryDatabaseImpl;
import com.amaap.merchantsguide.service.MetalService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MetalControllerTest {

    MetalController metalController = new MetalController(new MetalService(new MetalRepository(new InMemoryDatabaseImpl())));

    @Test
    void shouldBeAbleToCreateMetal() {
        // act
        boolean result = metalController.create("silver", 345);
        // assert
        Assertions.assertTrue(result);


    }
}
