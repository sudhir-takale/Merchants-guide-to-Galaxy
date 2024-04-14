package com.amaap.merchantsguide.controller;

import com.amaap.merchantsguide.controller.dto.HttpStatus;
import com.amaap.merchantsguide.controller.dto.Response;
import com.amaap.merchantsguide.service.FileProcessingService;

import java.io.FileNotFoundException;

public class InputProcessingController {
    private FileProcessingService fileProcessingService;

    public InputProcessingController(FileProcessingService fileProcessingService) {
        this.fileProcessingService = fileProcessingService;
    }

    public Response readInputFile(String filePath) throws FileNotFoundException {
        fileProcessingService.processInputFile(filePath);
        return new Response(HttpStatus.OK, "File has been processed successfully!");
    }
}
