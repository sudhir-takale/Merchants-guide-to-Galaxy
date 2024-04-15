package com.amaap.merchantsguide.repository;

import com.amaap.merchantsguide.domain.model.entity.Metal;
import com.amaap.merchantsguide.repository.db.InMemoryDatabaseImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class MetalRepositoryTest {

    MetalRepository metalRepository = new MetalRepository(new InMemoryDatabaseImpl());

    @Test
    void shouldBeAbleToGetAllMetals() {
        // act
        List<Metal> metal = metalRepository.getMetals();

        // assert
        Assertions.assertEquals(3, metal.size());

    }

}