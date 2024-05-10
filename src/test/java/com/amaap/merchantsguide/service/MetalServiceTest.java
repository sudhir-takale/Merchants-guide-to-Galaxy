package com.amaap.merchantsguide.service;

import com.amaap.merchantsguide.repository.MetalRepositoryImpl;
import com.amaap.merchantsguide.repository.db.impl.FakeInMemoryDatabase;
import com.amaap.merchantsguide.service.exception.InValidMetalFoundException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MetalServiceTest {

    MetalService metalService = new MetalService(new MetalRepositoryImpl(new FakeInMemoryDatabase()));

    @Test
    void shouldCreateMetalSuccessfully() throws InValidMetalFoundException {
        // arrange
        String metalName = "Gold";
        int credit = 100;

        // act
        boolean result = metalService.create(metalName, credit);

        // assert
        assertTrue(result);
    }

    @Test
    public void shouldNotCreateMetalIfMetalNameIsEmpty() throws InValidMetalFoundException {
        // arrange
        String metalName = "";
        int credit = 100;

        // act
        boolean result = metalService.create(metalName, credit);

        // assert
        assertFalse(result);
    }
    @Test
    public void shouldNotCreateMetalIfMetalCreditIsNegative() throws InValidMetalFoundException {
        // arrange
        String metalName = "Silver";
        int credit = -100;

        // act
        boolean result = metalService.create(metalName, credit);

        // assert
        assertFalse(result);
    }
}