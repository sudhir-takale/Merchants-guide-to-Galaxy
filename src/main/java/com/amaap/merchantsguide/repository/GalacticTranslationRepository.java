package com.amaap.merchantsguide.repository;

import com.amaap.merchantsguide.domain.model.valueobject.GalacticTranslation;
import com.amaap.merchantsguide.repository.db.InMemoryDatabase;

import java.util.List;

public class GalacticTranslationRepository {
    private InMemoryDatabase inMemoryDatabase;

    public GalacticTranslationRepository(InMemoryDatabase inMemoryDatabase) {
        this.inMemoryDatabase = inMemoryDatabase;
    }

    public void save(GalacticTranslation galacticTranslation) {
        this.inMemoryDatabase.saveTranslation(galacticTranslation);

    }

    public List<GalacticTranslation> getTranslation() {
       return  this.inMemoryDatabase.getAllTranslations();
    }
}
