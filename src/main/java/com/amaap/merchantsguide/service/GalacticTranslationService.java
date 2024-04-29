package com.amaap.merchantsguide.service;

import com.amaap.merchantsguide.domain.model.valueobject.GalacticTranslation;
import com.amaap.merchantsguide.repository.GalacticTranslationRepositoryImpl;
import com.google.inject.Inject;

public class GalacticTranslationService {
    private final GalacticTranslationRepositoryImpl translationRepository;

    @Inject
    public GalacticTranslationService(GalacticTranslationRepositoryImpl translationRepository) {
        this.translationRepository = translationRepository;
    }

    public void createTranslation(String unit, char numeral) {
        GalacticTranslation galacticTranslation = new GalacticTranslation(unit, numeral);
        translationRepository.save(galacticTranslation);
    }

}
