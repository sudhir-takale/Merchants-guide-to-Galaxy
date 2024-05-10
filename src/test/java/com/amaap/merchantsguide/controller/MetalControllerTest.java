package com.amaap.merchantsguide.controller;

import com.amaap.merchantsguide.controller.dto.HttpStatus;
import com.amaap.merchantsguide.controller.dto.Response;
import com.amaap.merchantsguide.repository.MetalRepositoryImpl;
import com.amaap.merchantsguide.repository.db.impl.FakeInMemoryDatabase;
import com.amaap.merchantsguide.service.MetalService;
import com.amaap.merchantsguide.service.exception.InValidMetalFoundException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MetalControllerTest {

    MetalController metalController = new MetalController(new MetalService(new MetalRepositoryImpl(new FakeInMemoryDatabase())));

    @Test
    void shouldBeAbleToCreateMetal() throws InValidMetalFoundException {
        // arrange
        Response expected = new Response(HttpStatus.OK, "success");

        // act
        Response result = metalController.create("silver", 345);

        // assert
        assertEquals(expected, result);
    }

    @Test
    void shouldReturnBadResponseIfEmptyMetalIsPassed() throws InValidMetalFoundException {
        // arrange
        Response expected = new Response(HttpStatus.BAD_REQUEST, "failed");

        // act
        Response result = metalController.create("", 345);

        // assert
        assertEquals(expected, result);
    }

    @Test
    void shouldReturnBadResponseIfNegativeCreditsIsPassed() throws InValidMetalFoundException {
        // arrange
        Response expected = new Response(HttpStatus.BAD_REQUEST, "failed");

        // act
        Response result = metalController.create("Silver", -345);

        // assert
        assertEquals(expected, result);
    }



}
