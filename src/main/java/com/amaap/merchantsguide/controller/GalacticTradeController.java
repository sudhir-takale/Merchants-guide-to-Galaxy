package com.amaap.merchantsguide.controller;

import com.amaap.merchantsguide.controller.dto.HttpStatus;
import com.amaap.merchantsguide.controller.dto.Response;
import com.amaap.merchantsguide.service.GalacticTradeService;
import com.google.inject.Inject;

public class GalacticTradeController {
    private final GalacticTradeService galacticTradeService;

    @Inject
    public GalacticTradeController(GalacticTradeService galacticTradeService) {
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
