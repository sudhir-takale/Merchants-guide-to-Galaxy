package com.amaap.merchantsguide.service;

import com.amaap.merchantsguide.domain.model.entity.GalacticTransaction;
import com.amaap.merchantsguide.domain.service.QueryProcessor;
import com.amaap.merchantsguide.repository.GalacticTransactionRepository;
import com.amaap.merchantsguide.service.dto.GalacticQueryDto;
import com.amaap.merchantsguide.service.dto.GalacticTranslationDto;
import com.amaap.merchantsguide.service.exception.InvalidGalacticTransactionFound;
import com.amaap.merchantsguide.service.validator.TransactionValidator;

import java.util.ArrayList;
import java.util.List;

public class GalacticTransactionService {
    private final GalacticTransactionRepository transactionRepository;
    QueryProcessor queryProcessor = new QueryProcessor();

    public GalacticTransactionService(GalacticTransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public boolean createTransaction(String unit, String metal, int credits) throws InvalidGalacticTransactionFound {
        if (TransactionValidator.validateTransaction(unit, metal, credits))
            throw new InvalidGalacticTransactionFound("Invalid " + "argument passed exception");

        GalacticTransaction galacticTransaction = new GalacticTransaction(unit, metal, credits);
        return transactionRepository.saveTransaction(galacticTransaction) == 1;
    }

    public List<GalacticTransaction> fetchTransactions() {
        return transactionRepository.getTransactions();
    }


    public List<GalacticQueryDto> getAllQueries() {
        return this.transactionRepository.getAllQueries();
    }

    public List<GalacticTranslationDto> getTranslationDto() {
        return this.transactionRepository.getTranslationDto();
    }

    public List<String> getMetals() {
        List<String> metals = new ArrayList<String>();
        List<GalacticTransaction> transactionList = fetchTransactions();
        for (GalacticTransaction transaction : transactionList) {
            metals.add(transaction.getMetal());
        }
        return metals;
    }

    public void resolveQueries() {

        List<GalacticQueryDto> queries = getAllQueries();
        for (GalacticQueryDto query : queries) {

            String line = query.getQuery();

            String[] metal = line.split(" ");

            if (checkForPlainUnits(metal)) {
                String numeral = getNumeralValue(metal);
                queryProcessor.processQueries(numeral, line);
            } else if (checkForMetal(metal)) {
                int onePartValue = getNumeralValueWithMetal(metal[2]);
                String[] unitValue = {metal[0], metal[1]};
                String numeral = getNumeralValue(unitValue);
                queryProcessor.processWithMetal(numeral, onePartValue, line);
            } else {
                queryProcessor.processKnownQuery(line);
            }

        }
    }

    private int getNumeralValueWithMetal(String metal) {
        String unit = "";
        int credit = 0;

        List<GalacticTransaction> transactionList = fetchTransactions();
        for (GalacticTransaction transaction : transactionList) {
            if (transaction.getMetal().equalsIgnoreCase(metal)) {
                unit = transaction.getTransactionName();
                credit = transaction.getCredit();
            }
        }
        String[] unitMetal = unit.split(" ");
        String romanNumeral = getNumeralValue(unitMetal);
        int number = queryProcessor.convertToNumber(romanNumeral);
        int onePartValue = credit / number;
        return onePartValue;
    }

    private boolean checkForMetal(String[] metal) {

        List<String> metalList = getMetals();
        return metalList.contains(metal[1]);
    }

    private String getNumeralValue(String[] metal) {
        StringBuilder builder = new StringBuilder();
        List<GalacticTranslationDto> token = getTranslationDto();

        for (String unit : metal) {
            boolean found = false;
            for (GalacticTranslationDto dto : token) {
                if (dto.getGalacticUnit().equals(unit)) {
                    builder.append(dto.getRomanNumeral());
                    found = true;
                    break;
                }
            }
        }
        return builder.toString();
    }

    private boolean checkForPlainUnits(String[] metal) {

        List<GalacticTranslationDto> token = getTranslationDto();

        for (String unit : metal) {
            boolean found = false;
            for (GalacticTranslationDto dto : token) {
                if (dto.getGalacticUnit().equals(unit)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return false;
            }
        }
        return true;
    }

}



