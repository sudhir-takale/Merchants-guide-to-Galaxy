package com.amaap.merchantsguide.controller;

import com.amaap.merchantsguide.repository.GalacticTranslationRepositoryImpl;
import com.amaap.merchantsguide.repository.db.impl.FakeInMemoryDatabase;
import com.amaap.merchantsguide.service.GalacticTranslationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GalacticTranslationControllerTest {
    GalacticTranslationController galacticTranslationController =
            new GalacticTranslationController(new GalacticTranslationService(new GalacticTranslationRepositoryImpl(new FakeInMemoryDatabase())));




    @Test
    void shouldBeAbleToCreateANewGalaxyTranslation() {
        // act
        boolean result = galacticTranslationController.create("glob", 'I');
        // assert
        Assertions.assertTrue(result);

    }



}
