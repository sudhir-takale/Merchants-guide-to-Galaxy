package com.amaap.merchantsguide.repository;

import com.amaap.merchantsguide.domain.model.valueobject.GalacticTranslation;
import com.amaap.merchantsguide.repository.db.InMemoryDatabaseImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class GalacticTranslationRepositoryTest {

    GalacticTranslationRepository galacticTranslationRepository =
            new GalacticTranslationRepository(new InMemoryDatabaseImpl());

    @Test
    void shouldBeAbleToGetAllTranslations() {
        // act
        galacticTranslationRepository.save(new GalacticTranslation("glob",'I'));
        galacticTranslationRepository.save(new GalacticTranslation("prok",'V'));
        galacticTranslationRepository.save(new GalacticTranslation("tegj",'L'));
        galacticTranslationRepository.save(new GalacticTranslation("pish",'X'));
        List<GalacticTranslation> result = galacticTranslationRepository.getTranslation();

        // assert
        Assertions.assertEquals(4, result.size());
    }

}