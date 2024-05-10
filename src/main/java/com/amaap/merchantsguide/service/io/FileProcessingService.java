package com.amaap.merchantsguide.service.io;

import com.amaap.merchantsguide.service.GalacticTradeService;
import com.amaap.merchantsguide.service.GalacticTranslationService;
import com.amaap.merchantsguide.service.exception.InvalidParameterTypeException;
import com.amaap.merchantsguide.service.io.exception.InvalidFilePathNotExistException;
import com.amaap.merchantsguide.service.io.validator.FilePathValidator;
import com.google.inject.Inject;

import java.io.IOException;

public class FileProcessingService {
    private final GalacticTradeService galacticTradeService;
    private final GalacticTranslationService galacticTranslationService;

    @Inject
    public FileProcessingService(GalacticTradeService galacticTradeService, GalacticTranslationService galacticTranslationService) {
        this.galacticTradeService = galacticTradeService;
        this.galacticTranslationService = galacticTranslationService;
    }

    public boolean processInputFile(String filePath) throws IOException, InvalidFilePathNotExistException, InvalidParameterTypeException {

        if (FilePathValidator.validateFilePath(filePath)) throw new InvalidFilePathNotExistException("File path not valid");

        return FileReaderService.readFile(filePath, galacticTradeService, galacticTranslationService);
    }

}
