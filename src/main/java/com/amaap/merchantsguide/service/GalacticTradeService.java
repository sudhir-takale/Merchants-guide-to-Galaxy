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
    QueryProcessor queryProcessor = new QueryProcessor();

    public GalacticTradeService(GalacticTradeRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public boolean createTransaction(String unit, String metal, int credits) throws InvalidGalacticTransactionFound {
        if (TransactionValidator.validateTransaction(unit, metal, credits))
            throw new InvalidGalacticTransactionFound("Invalid " + "argument passed exception");

        GalacticTrade galacticTrade = new GalacticTrade(unit, metal, credits);
        return transactionRepository.saveTransaction(galacticTrade) == 1;
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

    public List<GalacticTranslation> getTranslationDto() {
        return this.transactionRepository.getTranslationDto();
    }



}



