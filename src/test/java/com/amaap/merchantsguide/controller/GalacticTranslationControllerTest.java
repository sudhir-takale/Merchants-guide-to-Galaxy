package com.amaap.merchantsguide.controller;

import com.amaap.merchantsguide.controller.dto.HttpStatus;
import com.amaap.merchantsguide.controller.dto.Response;
import com.amaap.merchantsguide.repository.impl.GalacticTranslationRepositoryImpl;
import com.amaap.merchantsguide.repository.db.impl.FakeInMemoryDatabase;
import com.amaap.merchantsguide.service.GalacticTranslationService;
import com.amaap.merchantsguide.service.exception.InvalidGalacticTransactionFoundException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GalacticTranslationControllerTest {
    GalacticTranslationController galacticTranslationController =
            new GalacticTranslationController(new GalacticTranslationService(new GalacticTranslationRepositoryImpl(new FakeInMemoryDatabase())));


    @Test
    void shouldBeAbleToCreateANewGalaxyTranslation() throws InvalidGalacticTransactionFoundException {
        // arrange
        Response expected = new Response(HttpStatus.OK, "success");

        // act
        Response result = galacticTranslationController.create("glob", 'I');

        // assert
        assertEquals(expected, result);
    }

    @Test
    void shouldReturnBadResponseIfInvalidTranslationPassed() throws InvalidGalacticTransactionFoundException {
        // arrange
        Response expected = new Response(HttpStatus.BAD_REQUEST, "failed");

        // act
        Response result = galacticTranslationController.create("", 'I');

        // assert
        assertEquals(expected, result);

    }

    @Test
    void shouldReturnBadResponseIfInvalidPassed() throws InvalidGalacticTransactionFoundException {
        // arrange
        Response expected = new Response(HttpStatus.BAD_REQUEST, "failed");

        // act
        Response result = galacticTranslationController.create("", 'I');

        // assert
        assertEquals(expected, result);

    }



}
