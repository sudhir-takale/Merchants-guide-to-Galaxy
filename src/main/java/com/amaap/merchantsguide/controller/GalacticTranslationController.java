package com.amaap.merchantsguide.controller;

import com.amaap.merchantsguide.controller.dto.HttpStatus;
import com.amaap.merchantsguide.controller.dto.Response;
import com.amaap.merchantsguide.service.GalacticTranslationService;
import com.amaap.merchantsguide.service.exception.InvalidGalacticTransactionFoundException;

public class GalacticTranslationController {
    private final GalacticTranslationService galacticTranslationService;

    public GalacticTranslationController(GalacticTranslationService galacticTranslationService) {
        this.galacticTranslationService = galacticTranslationService;
    }

    public Response create(String unit, char numeral) throws InvalidGalacticTransactionFoundException {
        try {
            this.galacticTranslationService.createTranslation(unit, numeral);
            return new Response(HttpStatus.OK, "success");
        } catch (InvalidGalacticTransactionFoundException e) {
            return new Response(HttpStatus.BAD_REQUEST, "failed");
        }
    }
}
