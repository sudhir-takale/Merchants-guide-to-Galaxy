package com.amaap.merchantsguide.service;

import com.amaap.merchantsguide.repository.db.impl.FakeInMemoryDatabase;
import com.amaap.merchantsguide.repository.impl.MetalRepositoryImpl;
import com.amaap.merchantsguide.service.exception.InValidMetalFoundException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
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
    public void shouldThrowExceptionIfMetalNameIsEmpty() throws InValidMetalFoundException {
        // arrange
        String metalName = "";
        int credit = 100;

        // act & assert
        assertThrows(InValidMetalFoundException.class, () -> metalService.create(metalName, credit));

    }

    @Test
    public void shouldNotCreateMetalIfMetalCreditIsNegative() throws InValidMetalFoundException {
        // arrange
        String metalName = "Silver";
        int credit = -100;

        // act & assert
        assertThrows(InValidMetalFoundException.class, () -> metalService.create(metalName, credit));

    }
}