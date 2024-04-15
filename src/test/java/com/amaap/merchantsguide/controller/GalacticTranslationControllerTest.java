package com.amaap.merchantsguide.controller;

import com.amaap.merchantsguide.domain.model.valueobject.GalacticTranslation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GalacticTranslationControllerTest {
    GalacticTranslationController galacticTranslationController = new GalacticTranslationController();
    @Test
    void shouldBeAbleToCreateANewGalaxyTranslation() {
        // act
        boolean result = galacticTranslationController.create("glob",'I');
        // assert
        Assertions.assertTrue(result);

    }



}
