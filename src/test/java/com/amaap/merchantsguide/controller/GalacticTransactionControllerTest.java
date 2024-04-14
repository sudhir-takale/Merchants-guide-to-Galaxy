package com.amaap.merchantsguide.controller;

import com.amaap.merchantsguide.controller.dto.HttpStatus;
import com.amaap.merchantsguide.controller.dto.Response;
import com.amaap.merchantsguide.repository.impl.GalacticTransactionRepositoryImpl;
import com.amaap.merchantsguide.service.GalacticTransactionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GalacticTransactionControllerTest {

    GalacticTransactionController galacticTransactionController =
            new GalacticTransactionController(new GalacticTransactionService(new GalacticTransactionRepositoryImpl()));

    @Test
    void shouldBeAbleToGetAllNewTransaction() {
        Response expected = new Response(HttpStatus.OK, "Transactions has been fetched successfully");

        // act
        Response actual = galacticTransactionController.fetchAllTransactions();

        // assert
        Assertions.assertEquals(expected, actual);

    }


}
