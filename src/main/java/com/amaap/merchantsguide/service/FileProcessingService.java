package com.amaap.merchantsguide.service;

import com.amaap.merchantsguide.repository.FileRepository;
import com.amaap.merchantsguide.service.dto.GalacticQueryDto;
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
            if (!parseInputLine(line)) return false;
        }
        return true;
    }

    private boolean parseInputLine(String line) {
        if (line.contains("is") && line.length() == 3) {
            foundGalacticUnit(line);
        } else if (line.contains("credits")) {
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
        for (String token : transactionToken) {
            System.out.print(token + "  ");
        }
        System.out.println(transactionToken.length);
        String unit = transactionToken[0] + transactionToken[3];
        System.out.println("Unit is " + unit);
        System.out.println("credit is" + transactionToken[4]);
        galacticTransactionService.createTransaction(unit, transactionToken[2], Integer.parseInt(transactionToken[4]));

    }

    private void foundGalacticUnit(String line) {
        String[] parts = line.split("is");
        GalacticTokenDto token = new GalacticTokenDto(parts[0], parts[1].charAt(0));
        fileRepository.saveTranslation(token);
    }
}
