package com.amaap.merchantsguide.controller;

import com.amaap.merchantsguide.controller.dto.HttpStatus;
import com.amaap.merchantsguide.controller.dto.Response;

public class GalacticTransactionController {

    public Response fetchAllTransactions() {
        return new Response(HttpStatus.OK, "Transactions has been fetched successfully");
    }
}
