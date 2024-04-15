package com.amaap.merchantsguide.service;

import com.amaap.merchantsguide.domain.model.entity.GalacticTrade;
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
//        System.out.println(metal + credits + unit);
        int perUnitCredits = getPerUnitCreditOfMetal(unit, metal, credits);
        metalService.create(metal, credits);

        return transactionRepository.saveTransaction(galacticTrade) == 1;
    }

    private int getPerUnitCreditOfMetal(String unit, String metal, int credits) {

        String[] units = unit.split(" ");
        String numeral = getNumeralValue(units);
        System.out.println("Numeral is " + numeral);
        int number = QueryProcessor.convertToNumber(numeral);
        return credits / number;
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
//        System.out.println(builder.toString());
        return builder.toString();
    }

    public void createQuery(String query) {
        this.transactionRepository.createQuery(query);
    }


    public List<GalacticTrade> fetchTransactions() {
        return transactionRepository.getTransactions();
    }


    public List<GalacticQueryDto> getAllQueries() {
        return this.transactionRepository.getAllQueries();
    }


    public List<GalacticTranslation> getTranslations() {
        return this.transactionRepository.getTranslationDto();
    }


}



