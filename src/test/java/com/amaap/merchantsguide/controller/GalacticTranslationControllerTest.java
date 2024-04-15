package com.amaap.merchantsguide.controller;

import com.amaap.merchantsguide.repository.GalacticTranslationRepository;
import com.amaap.merchantsguide.repository.db.InMemoryDatabaseImpl;
import com.amaap.merchantsguide.service.GalacticTranslationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GalacticTranslationControllerTest {
    GalacticTranslationController galacticTranslationController =
            new GalacticTranslationController(new GalacticTranslationService(new GalacticTranslationRepository(new InMemoryDatabaseImpl())));

    @Test
    void shouldBeAbleToCreateANewGalaxyTranslation() {
        // act
        boolean result = galacticTranslationController.create("glob", 'I');
        // assert
        Assertions.assertTrue(result);

    }


}
