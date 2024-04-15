package com.amaap.merchantsguide.service.io;

import com.amaap.merchantsguide.config.ConfigValidator;
import com.amaap.merchantsguide.domain.model.valueobject.GalacticTranslation;
import com.amaap.merchantsguide.repository.FileRepository;
import com.amaap.merchantsguide.service.GalacticTransactionService;
import com.amaap.merchantsguide.repository.dto.GalacticQueryDto;
import com.amaap.merchantsguide.service.exception.InValidMetalFoundException;
import com.amaap.merchantsguide.service.exception.InvalidGalacticTransactionFound;
import com.amaap.merchantsguide.service.exception.InvalidGalacticTransactionUnitException;
import com.amaap.merchantsguide.service.exception.InvalidParameterTypeException;
import com.amaap.merchantsguide.service.io.exception.InvalidFilePathNotExist;
import com.amaap.merchantsguide.service.io.validator.FilePathValidator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class FileProcessingService {
    private final FileRepository fileRepository;
    private final GalacticTransactionService galacticTransactionService;
    private final ConfigValidator configValidator;

    public FileProcessingService(FileRepository fileRepository, GalacticTransactionService galacticTransactionService) {
        this.fileRepository = fileRepository;
        this.galacticTransactionService = galacticTransactionService;
        this.configValidator = new ConfigValidator();
    }

    public boolean processInputFile(String filePath) throws IOException, InvalidFilePathNotExist, InvalidParameterTypeException {

        if (FilePathValidator.validateFilePath(filePath)) throw new InvalidFilePathNotExist("File path not valid");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            if (!parseInputLine(line)) return false;
        }
        return true;
    }

    public boolean parseInputLine(String line) throws InvalidParameterTypeException {

        if (line.matches("^\\w+\\s+is\\s+\\w+$")) {
            foundGalacticUnit(line);
        } else if (line.contains("Credits")) {
            foundGalacticTransaction(line);

        } else if ((line.contains("?") || line.contains("How many"))) {
            foundGalacticQuery(line);
        }
        return true;
    }

    private void foundGalacticQuery(String line) {
        if (line.contains("is")) {
            String[] transactionToken = line.split("is");
            GalacticQueryDto query = new GalacticQueryDto(transactionToken[1]);
            fileRepository.save(query);
        } else {
            GalacticQueryDto query = new GalacticQueryDto(line);
            fileRepository.save(query);
        }
    }

    private void foundGalacticTransaction(String line) throws InvalidParameterTypeException {
        Map<Integer, String> metals = configValidator.getMetals();
        Map<Integer, String> transaction = configValidator.getTransaction();

        String[] transactionToken = line.split(" ");
        String unit = transactionToken[0] + " " + transactionToken[1];
        if (!transaction.containsValue(unit.trim()))
            throw new InvalidGalacticTransactionFound(unit + " Invalid galactic transaction found");
        if (!metals.containsValue(transactionToken[2]) || Integer.parseInt(transactionToken[4]) < 0)
            throw new InValidMetalFoundException(transactionToken[2] + " Invalid metal type found");
        else {
            galacticTransactionService.createTransaction(unit, transactionToken[2], Integer.parseInt(transactionToken[4]));
        }
    }

    private void foundGalacticUnit(String line) throws InvalidParameterTypeException {
        Map<String, Character> galacticTranslation = configValidator.getUnits();
        String[] parts = line.split(" ");
        String unit = parts[0].trim();
        char numeral = parts[2].charAt(0);
        if (!galacticTranslation.containsKey(unit) || !galacticTranslation.containsValue(numeral))
            throw new InvalidGalacticTransactionUnitException(unit + " Invalid galactic translation found");
        GalacticTranslation token = new GalacticTranslation(unit, numeral);
        fileRepository.saveTranslation(token);
    }
}
