package com.amaap.merchantsguide.repository;

import com.amaap.merchantsguide.domain.model.valueobject.GalacticTranslation;
import com.amaap.merchantsguide.repository.db.InMemoryDatabase;

public class GalacticTranslationRepository {
    private InMemoryDatabase inMemoryDatabase;

    public GalacticTranslationRepository(InMemoryDatabase inMemoryDatabase) {
        this.inMemoryDatabase = inMemoryDatabase;
    }

    public void save(GalacticTranslation galacticTranslation) {
        this.inMemoryDatabase.saveTranslation(galacticTranslation);

    }

}
