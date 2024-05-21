package com.amaap.merchantsguide.repository.impl;

import com.amaap.merchantsguide.domain.model.valueobject.GalacticTranslation;
import com.amaap.merchantsguide.repository.GalacticTranslationRepository;
import com.amaap.merchantsguide.repository.db.InMemoryDatabase;
import com.google.inject.Inject;

import java.util.List;

public class GalacticTranslationRepositoryImpl implements GalacticTranslationRepository {
    private final InMemoryDatabase inMemoryDatabase;

    @Inject
    public GalacticTranslationRepositoryImpl(InMemoryDatabase inMemoryDatabase) {
        this.inMemoryDatabase = inMemoryDatabase;
    }

    @Override
    public void save(GalacticTranslation galacticTranslation) {
        this.inMemoryDatabase.saveTranslation(galacticTranslation);

    }

    @Override
    public List<GalacticTranslation> getTranslation() {
        return this.inMemoryDatabase.getAllTranslations();
    }
}
