package com.amaap.merchantsguide.controller;

import com.amaap.merchantsguide.service.GalacticTranslationService;

public class GalacticTranslationController {
    private GalacticTranslationService galacticTranslationService;

    public GalacticTranslationController(GalacticTranslationService galacticTranslationService) {
        this.galacticTranslationService = galacticTranslationService;
    }

    public boolean create(String unit, char numeral) {
        this.galacticTranslationService.createTranslation(unit, numeral);
        return true;
    }
}
