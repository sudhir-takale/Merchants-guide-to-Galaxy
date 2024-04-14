package com.amaap.merchantsguide.service;

import com.amaap.merchantsguide.repository.FileRepository;
import com.amaap.merchantsguide.service.dto.GalacticQueryDto;
import com.amaap.merchantsguide.service.dto.GalacticTokenDto;
import com.amaap.merchantsguide.service.exception.InvalidFilePathNotExist;
import com.amaap.merchantsguide.service.validator.FilePathValidator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileProcessingService {
    private final FileRepository fileRepository;
    private final GalacticTransactionService galacticTransactionService;

    public FileProcessingService(FileRepository fileRepository, GalacticTransactionService galacticTransactionService) {
        this.fileRepository = fileRepository;
        this.galacticTransactionService = galacticTransactionService;
    }

    public boolean processInputFile(String filePath) throws IOException, InvalidFilePathNotExist {

        if(FilePathValidator.validateFilePath(filePath)) throw new InvalidFilePathNotExist("File path not valid");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            if (!parseInputLine(line)) return false;
        }
        return true;
    }

     boolean parseInputLine(String line) {

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

    private void foundGalacticTransaction(String line) {
        String[] transactionToken = line.split(" ");
        String unit = transactionToken[0] + " " + transactionToken[1];
        galacticTransactionService.createTransaction(unit, transactionToken[2], Integer.parseInt(transactionToken[4]));

    }

    private void foundGalacticUnit(String line) {
        String[] parts = line.split("is");
        String part = parts[1];
        GalacticTokenDto token = new GalacticTokenDto(parts[0], parts[1].charAt(0));
        fileRepository.saveTranslation(token);
    }
}
