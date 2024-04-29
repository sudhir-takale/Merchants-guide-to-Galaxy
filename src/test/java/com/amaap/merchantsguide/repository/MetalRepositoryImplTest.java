package com.amaap.merchantsguide.repository;

import com.amaap.merchantsguide.domain.model.entity.Metal;
import com.amaap.merchantsguide.repository.db.impl.FakeInMemoryDatabase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class MetalRepositoryImplTest {

    MetalRepositoryImpl metalRepositoryImpl = new MetalRepositoryImpl(new FakeInMemoryDatabase());

    @Test
    void shouldBeAbleToGetAllMetals() {
        // act
        metalRepositoryImpl.add(new Metal("Silver",34));
        metalRepositoryImpl.add(new Metal("Gold",34));
        List<Metal> metal = metalRepositoryImpl.getMetals();

        // assert
        Assertions.assertEquals(2, metal.size());

    }

}