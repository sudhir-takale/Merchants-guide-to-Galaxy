package com.amaap.merchantsguide.controller;

import com.amaap.merchantsguide.controller.dto.HttpStatus;
import com.amaap.merchantsguide.controller.dto.Response;
import com.amaap.merchantsguide.service.GalacticTransactionService;

public class GalacticTransactionController {
    private final GalacticTransactionService galacticTransactionService;

    public GalacticTransactionController(GalacticTransactionService galacticTransactionService) {
        this.galacticTransactionService = galacticTransactionService;
    }

    public Response fetchAllTransactions() {
        this.galacticTransactionService.fetchTransactions();
        return new Response(HttpStatus.OK, "Transactions has been fetched successfully");
    }

//    public Response processQueries() {
//        this.galacticTransactionService.resolveQueries();
//        return new Response(HttpStatus.OK, "All queries resolved successfully");
//    }
}
