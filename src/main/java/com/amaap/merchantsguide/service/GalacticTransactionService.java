package com.amaap.merchantsguide.service;

import com.amaap.merchantsguide.domain.model.entity.GalacticTransaction;
import com.amaap.merchantsguide.domain.service.QueryProcessor;
import com.amaap.merchantsguide.repository.GalacticTransactionRepository;
import com.amaap.merchantsguide.service.dto.GalacticQueryDto;
import com.amaap.merchantsguide.service.dto.GalacticTokenDto;
import com.amaap.merchantsguide.service.exception.InvalidGalacticTransactionFound;
import com.amaap.merchantsguide.service.validator.TransactionValidator;

import java.util.ArrayList;
import java.util.List;

public class GalacticTransactionService {
    private final GalacticTransactionRepository transactionRepository;

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

    public List<GalacticTokenDto> getTranslationDto() {
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
        for (int i = 0; i < queries.size(); i++) {

            String line = queries.get(i).toString();
            String[] metal = line.split(" ");

            if (checkForPlainUnits(metal)) {
                String numeral = getNumeralValue(metal);
                QueryProcessor queryProcessor = new QueryProcessor();
                queryProcessor.processQueries(numeral, line);
            } else if (checkForMetal(metal)) {
                    getNumeralValueWithMetal(metal);
            }

            String dirt = metal[2];
        }
    }

    private void getNumeralValueWithMetal(String[] metal) {

    }

    private boolean checkForMetal(String[] metal) {

        List<String> metalList = getMetals();
        return metalList.contains(metal[2]);
    }

    private String getNumeralValue(String[] metal) {
        StringBuilder builder = new StringBuilder();
        List<GalacticTokenDto> token = getTranslationDto();

        for (String unit : metal) {
            boolean found = false;
            for (GalacticTokenDto dto : token) {
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

        List<GalacticTokenDto> token = getTranslationDto();

        for (String unit : metal) {
            boolean found = false;
            for (GalacticTokenDto dto : token) {
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


}
