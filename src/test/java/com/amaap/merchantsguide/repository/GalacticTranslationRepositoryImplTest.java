package com.amaap.merchantsguide.repository;

import com.amaap.merchantsguide.domain.model.valueobject.GalacticTranslation;
import com.amaap.merchantsguide.repository.db.impl.FakeInMemoryDatabase;
import com.amaap.merchantsguide.repository.impl.GalacticTranslationRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class GalacticTranslationRepositoryImplTest {

    GalacticTranslationRepositoryImpl galacticTranslationRepositoryImpl =
            new GalacticTranslationRepositoryImpl(new FakeInMemoryDatabase());

    @Test
    void shouldBeAbleToGetAllTranslations() {
        // act
        galacticTranslationRepositoryImpl.save(new GalacticTranslation("glob",'I'));
        galacticTranslationRepositoryImpl.save(new GalacticTranslation("prok",'V'));
        galacticTranslationRepositoryImpl.save(new GalacticTranslation("tegj",'L'));
        galacticTranslationRepositoryImpl.save(new GalacticTranslation("pish",'X'));
        List<GalacticTranslation> result = galacticTranslationRepositoryImpl.getTranslation();

        // assert
        Assertions.assertEquals(4, result.size());
    }

}