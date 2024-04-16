package com.amaap.merchantsguide.service;

import com.amaap.merchantsguide.domain.model.entity.GalacticTrade;
import com.amaap.merchantsguide.domain.model.entity.Metal;
import com.amaap.merchantsguide.domain.model.valueobject.GalacticTranslation;
import com.amaap.merchantsguide.domain.service.QueryProcessor;
import com.amaap.merchantsguide.repository.GalacticTradeRepository;
import com.amaap.merchantsguide.repository.dto.GalacticQueryDto;
import com.amaap.merchantsguide.service.exception.InvalidGalacticTransactionFound;
import com.amaap.merchantsguide.service.validator.TransactionValidator;

import java.util.List;

public class GalacticTradeService {
    private final GalacticTradeRepository transactionRepository;
    private final MetalService metalService;

    public GalacticTradeService(GalacticTradeRepository transactionRepository, MetalService metalService) {
        this.transactionRepository = transactionRepository;
        this.metalService = metalService;
    }

    public boolean createTransaction(String unit, String metal, int credits) throws InvalidGalacticTransactionFound {
        if (TransactionValidator.validateTransaction(unit, metal, credits))
            throw new InvalidGalacticTransactionFound("Invalid " + "argument passed exception");

        GalacticTrade galacticTrade = new GalacticTrade(unit, metal, credits);
        if (metal != null) {
            double perUnitCredits = getPerUnitCreditOfMetal(unit, metal, credits);
            metalService.create(metal, perUnitCredits);
        }

        return transactionRepository.saveTransaction(galacticTrade) == 1;
    }

    private double getPerUnitCreditOfMetal(String unit, String metal, int credits) {

        String[] units = unit.split(" ");
        String numeral = getNumeralValue(units);
        int number = QueryProcessor.convertToNumber(numeral);
        if(number == 0) return 0;
        return (double) (credits / number);
    }

    private String getNumeralValue(String[] metal) {
        StringBuilder builder = new StringBuilder();
        List<GalacticTranslation> token = getTranslations();

        for (String unit : metal) {
            boolean found = false;
            for (GalacticTranslation dto : token) {
                if (dto.getGalacticUnit().trim().equals(unit.trim())) {
                    builder.append(dto.getRomanNumeral());
                    found = true;
                    break;
                }
            }
        }
        return builder.toString();
    }

    public void createQuery(String query) {
        this.transactionRepository.createQuery(query);
    }

    public List<GalacticQueryDto> getAllQueries() {
        return this.transactionRepository.getAllQueries();
    }


    public List<GalacticTranslation> getTranslations() {
        return this.transactionRepository.getTranslationDto();
    }


    public void processQuery() {

        List<GalacticQueryDto> queryDtos = getAllQueries();
        for (GalacticQueryDto dto : queryDtos) {
            String[] unit = dto.getQuery().split(" ");
            if (unit.length > 4) {
                QueryProcessor.processInvalidQuery(dto.getQuery());

            } else if (unit.length == 3) {

                String[] newArray = {unit[0].trim(), unit[1].trim()};
                String romanValue = getNumeralValue(newArray);
                double credits = getCredits(unit[2]);
                QueryProcessor.processQuery(dto.getQuery(), romanValue, credits);
            } else {
                String romanValue = getNumeralValue(unit);
                QueryProcessor.processQueryWithoutMetal(dto.getQuery(), romanValue);
            }
        }

    }

    private double getCredits(String s) {
        double credit = 0;
        List<Metal> metals = getMetals();
        for (Metal metal : metals) {
            if (metal.getMetalName().trim().equals(s)) {
                credit = metal.getCredits();
            }
        }

        return credit;
    }

    public List<Metal> getMetals() {
        return transactionRepository.getMetals();
    }

    public List<GalacticTrade> fetchTransactions() {
        return this.transactionRepository.getTransactions();
    }
}



