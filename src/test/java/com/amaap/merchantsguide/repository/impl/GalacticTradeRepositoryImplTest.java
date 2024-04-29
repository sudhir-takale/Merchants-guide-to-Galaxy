package com.amaap.merchantsguide.repository.impl;

import com.amaap.merchantsguide.domain.model.entity.GalacticTrade;
import com.amaap.merchantsguide.repository.GalacticTradeRepository;
import com.amaap.merchantsguide.repository.db.impl.FakeInMemoryDatabase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class GalacticTradeRepositoryImplTest {

    GalacticTradeRepository galacticTradeRepository = new GalacticTradeRepositoryImpl(new FakeInMemoryDatabase());

    @Test
    void shouldBeAbleToSaveGalacticTransaction() {
        // arrange
        String unit = "glob glob";
        String metal = "Silver";
        int credits = 3910;
        GalacticTrade galacticTrade = new GalacticTrade(unit, metal, credits);

        //act
        int result = galacticTradeRepository.saveTransaction(galacticTrade);

        // assert

        Assertions.assertEquals(1, result);

    }

    @Test
    void shouldBeAbleGetAllGalacticTransaction() {
        // arrange
        String unit = "glob glob";
        String metal = "Silver";
        int credits = 3910;
        GalacticTrade galacticTrade = new GalacticTrade(unit, metal, credits);
        galacticTradeRepository.saveTransaction(galacticTrade);
        //act
        List<GalacticTrade> result = galacticTradeRepository.getTransactions();

        // assert
        Assertions.assertEquals(1, result.size());

    }


}