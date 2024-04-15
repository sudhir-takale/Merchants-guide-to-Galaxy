package com.amaap.merchantsguide.service;

import com.amaap.merchantsguide.domain.model.valueobject.GalacticTranslation;
import com.amaap.merchantsguide.repository.GalacticTranslationRepository;

public class GalacticTranslationService {
    private GalacticTranslationRepository translationRepository;

    public void createTranslation(String unit, char numeral) {
        GalacticTranslation galacticTranslation = new GalacticTranslation(unit, numeral);
        translationRepository.save(galacticTranslation);
    }

}
