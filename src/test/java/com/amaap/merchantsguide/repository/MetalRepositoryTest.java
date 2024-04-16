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
        metalRepository.add(new Metal("Silver",34));
        metalRepository.add(new Metal("Gold",34));
        List<Metal> metal = metalRepository.getMetals();

        // assert
        Assertions.assertEquals(2, metal.size());

    }

}