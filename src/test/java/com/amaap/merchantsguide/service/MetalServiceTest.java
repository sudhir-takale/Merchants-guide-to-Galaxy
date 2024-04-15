package com.amaap.merchantsguide.service;

import com.amaap.merchantsguide.repository.MetalRepository;
import com.amaap.merchantsguide.repository.db.InMemoryDatabaseImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MetalServiceTest {

    MetalService metalService = new MetalService(new MetalRepository(new InMemoryDatabaseImpl()));

    @Test
    void shouldCreateMetalSuccessfully() {
        // arrange
        String metalName = "Gold";
        int credit = 100;

        // act
        boolean result = metalService.create(metalName, credit);

        // assert
        assertTrue(result);
    }

    @Test
    public void shouldNotCreateMetalIfMetalNameIsEmpty() {
        // arrange
        String metalName = "";
        int credit = 100;

        // act
        boolean result = metalService.create(metalName, credit);

        // assert
        assertFalse(result);
    }
    @Test
    public void shouldNotCreateMetalIfMetalCreditIsNegative(){
        // arrange
        String metalName = "Silver";
        int credit = -100;

        // act
        boolean result = metalService.create(metalName, credit);

        // assert
        assertFalse(result);
    }
}