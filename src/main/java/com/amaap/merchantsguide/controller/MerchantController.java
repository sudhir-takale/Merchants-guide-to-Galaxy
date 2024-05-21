package com.amaap.merchantsguide.controller;

import com.amaap.merchantsguide.service.exception.InvalidParameterTypeException;
import com.amaap.merchantsguide.service.io.FileProcessingService;
import com.amaap.merchantsguide.service.io.exception.InvalidFilePathNotExistException;
import com.google.inject.Inject;

import java.io.IOException;

public class MerchantController {

    private final FileProcessingService fileProcessingService;

    @Inject
    public MerchantController(FileProcessingService fileProcessingService) {
        this.fileProcessingService = fileProcessingService;
    }

    public void processFile(String filePath) throws InvalidParameterTypeException, InvalidFilePathNotExistException, IOException {
        fileProcessingService.processInputFile(filePath);
    }
}
