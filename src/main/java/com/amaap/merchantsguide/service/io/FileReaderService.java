package com.amaap.merchantsguide.service.io;

import com.amaap.merchantsguide.service.GalacticTradeService;
import com.amaap.merchantsguide.service.GalacticTranslationService;
import com.amaap.merchantsguide.service.exception.InvalidParameterTypeException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderService {

    public static boolean readFile(String filePath, GalacticTradeService galacticTradeService, GalacticTranslationService galacticTranslationService) throws IOException, InvalidParameterTypeException {

        FileParserService fileParserService = new FileParserService(galacticTradeService, galacticTranslationService);

        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            if (line.isEmpty()) continue;
            line = line.replaceAll("\\s+", " ").trim();
            if (!fileParserService.parseInputLine(line)) return false;
        }
        return true;
    }
}
