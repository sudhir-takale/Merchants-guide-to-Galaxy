package com.amaap.merchantsguide.controller;

import com.amaap.merchantsguide.controller.dto.HttpStatus;
import com.amaap.merchantsguide.controller.dto.Response;
import com.amaap.merchantsguide.service.FileProcessingService;
import com.amaap.merchantsguide.service.exception.InvalidFilePathNotExist;
import com.amaap.merchantsguide.service.exception.InvalidGalacticTransactionFound;
import com.amaap.merchantsguide.service.exception.InvalidParameterTypeException;

import java.io.IOException;

public class InputProcessingController {
    private FileProcessingService fileProcessingService;

    public InputProcessingController(FileProcessingService fileProcessingService) {
        this.fileProcessingService = fileProcessingService;
    }

    public Response readInputFile(String filePath) throws IOException, InvalidFilePathNotExist, InvalidParameterTypeException {
        fileProcessingService.processInputFile(filePath);
        return new Response(HttpStatus.OK, "File has been processed successfully!");
    }



}
