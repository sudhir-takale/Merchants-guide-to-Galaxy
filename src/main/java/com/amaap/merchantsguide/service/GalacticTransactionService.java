package com.amaap.merchantsguide.service;

import com.amaap.merchantsguide.domain.model.entity.GalacticTransaction;
import com.amaap.merchantsguide.domain.model.valueobject.GalacticTranslation;
import com.amaap.merchantsguide.domain.service.QueryProcessor;
import com.amaap.merchantsguide.repository.GalacticTransactionRepository;
import com.amaap.merchantsguide.repository.dto.GalacticQueryDto;
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

    public List<GalacticTranslation> getTranslationDto() {
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

}



