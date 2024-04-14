package com.amaap.merchantsguide.repository.impl;

import com.amaap.merchantsguide.repository.FileRepository;
import com.amaap.merchantsguide.repository.db.InMemoryDatabaseImpl;
import com.amaap.merchantsguide.service.dto.GalacticQueryDto;
import com.amaap.merchantsguide.service.dto.GalacticTokenDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class FileRepositoryImplTest {

    FileRepository fileRepository = new FileRepositoryImpl(new InMemoryDatabaseImpl());

    @Test
    void shouldBeAbleToSaveTheGalacticUnits() {
        // arrange
        GalacticTokenDto galacticTokenDto = new GalacticTokenDto("glob", 'I');

        // act
        boolean result = fileRepository.saveTranslation(galacticTokenDto);

        // assert
        Assertions.assertTrue(result);

    }

 @Test
    void shouldBeAbleToSaveTheGalacticQueries() {
        // arrange
        GalacticQueryDto galacticTokenDto = new GalacticQueryDto("glob glob prok");

        // act
        boolean result = fileRepository.save(galacticTokenDto);

        // assert
        Assertions.assertTrue(result);

    }

    @Test
    void shouldBeAbleToGetAllQueries() {
        // arrange
        GalacticQueryDto galacticTokenDto = new GalacticQueryDto("glob glob prok");
        GalacticQueryDto galacticTokenDto2 = new GalacticQueryDto("glob prok prok");
        GalacticQueryDto galacticTokenDto3 = new GalacticQueryDto("glob pish prok");
        fileRepository.save(galacticTokenDto);
        fileRepository.save(galacticTokenDto2);
        fileRepository.save(galacticTokenDto3);

        // act
        List<GalacticQueryDto> queries = fileRepository.getQueryList();

        // assert
        Assertions.assertEquals(3, queries.size());

    }


}