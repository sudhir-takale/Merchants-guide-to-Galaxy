package com.amaap.merchantsguide.repository.impl.mongo;

import com.amaap.merchantsguide.domain.model.valueobject.GalacticTranslation;
import com.amaap.merchantsguide.repository.GalacticTranslationRepository;

import java.util.List;

public class GalacticTranslationRepositoryMongo implements GalacticTranslationRepository {
    @Override
    public void save(GalacticTranslation galacticTranslation) {

    }

    @Override
    public List<GalacticTranslation> getTranslation() {
        return List.of();
    }
}
