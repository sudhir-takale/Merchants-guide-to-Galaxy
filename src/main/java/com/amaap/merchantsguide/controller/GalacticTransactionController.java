package com.amaap.merchantsguide.controller;

import com.amaap.merchantsguide.controller.dto.HttpStatus;
import com.amaap.merchantsguide.controller.dto.Response;
import com.amaap.merchantsguide.service.GalacticTradeService;

public class GalacticTransactionController {
    private final GalacticTradeService galacticTradeService;

    public GalacticTransactionController(GalacticTradeService galacticTradeService) {
        this.galacticTradeService = galacticTradeService;
    }

    public Response fetchAllTransactions() {
        this.galacticTradeService.fetchTransactions();
        return new Response(HttpStatus.OK, "Transactions has been fetched successfully");
    }

    public Response processQueries() {
        this.galacticTradeService.processQuery();
        return new Response(HttpStatus.OK, "All queries resolved successfully");
    }
}
