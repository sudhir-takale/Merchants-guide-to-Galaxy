package com.amaap.merchantsguide.repository;

import com.amaap.merchantsguide.domain.model.valueobject.GalacticTranslation;

import java.util.List;

public interface GalacticTranslationRepository {

    void save(GalacticTranslation galacticTranslation);

    List<GalacticTranslation> getTranslation();
}
