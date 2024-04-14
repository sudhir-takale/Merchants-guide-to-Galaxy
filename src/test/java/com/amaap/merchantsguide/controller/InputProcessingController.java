package com.amaap.merchantsguide.controller;

import com.amaap.merchantsguide.controller.dto.HttpStatus;
import com.amaap.merchantsguide.controller.dto.Response;

public class InputProcessingController {
    public Response readInputFile(String filePath) {
        return new Response(HttpStatus.OK, "File has been processed successfully!");
    }
}
