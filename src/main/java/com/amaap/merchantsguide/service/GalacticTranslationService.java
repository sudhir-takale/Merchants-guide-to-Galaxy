package com.amaap.merchantsguide.service;

import com.amaap.merchantsguide.domain.model.valueobject.GalacticTranslation;
import com.amaap.merchantsguide.repository.impl.GalacticTranslationRepositoryImpl;
import com.amaap.merchantsguide.service.exception.InvalidGalacticTransactionFoundException;
import com.google.inject.Inject;

public class GalacticTranslationService {
    private final GalacticTranslationRepositoryImpl translationRepository;

    @Inject
    public GalacticTranslationService(GalacticTranslationRepositoryImpl translationRepository) {
        this.translationRepository = translationRepository;
    }

    public void createTranslation(String unit, char numeral) throws InvalidGalacticTransactionFoundException {
        if (unit.isEmpty() || unit.matches("[0-9]")) {
            throw new InvalidGalacticTransactionFoundException("invalid transaction found");

        }
        GalacticTranslation galacticTranslation = new GalacticTranslation(unit, numeral);
        translationRepository.save(galacticTranslation);
    }

}
