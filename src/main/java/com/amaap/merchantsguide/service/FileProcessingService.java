package com.amaap.merchantsguide.service;

import com.amaap.merchantsguide.domain.model.entity.GalacticTransaction;
import com.amaap.merchantsguide.repository.FileRepository;
import com.amaap.merchantsguide.service.dto.GalacticTokenDto;

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

    public boolean processInputFile(String filePath) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            parseInputLine(line);
        }
        return true;
    }

    private void parseInputLine(String line) {

        if (line.length() == 3) {
            if (line.contains("is")) {
                String[] parts = line.split("is");
                GalacticTokenDto token = new GalacticTokenDto(parts[0],parts[1].charAt(0));
            }
        } else if (line.contains("is")) {
            String[] transactionToken = line.split(" ");
            String unit = transactionToken[0] + transactionToken[1];
            GalacticTransaction galacticTransaction = new GalacticTransaction(unit, transactionToken[2], transactionToken[4]);
        } else if ((line.contains("How much") || line.contains("How many"))) {
            if (line.contains("is")) {
                String[] transactionToken = line.split("is");
                GalacticQuery query = newGalacticQuery(transactionToken[1]);
            } else {
                GalacticQuery query = newGalacticQuery(line);
            }
        }

    }
}
