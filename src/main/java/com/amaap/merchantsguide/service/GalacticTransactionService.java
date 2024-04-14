package com.amaap.merchantsguide.service;

import com.amaap.merchantsguide.domain.model.entity.GalacticTransaction;
import com.amaap.merchantsguide.domain.service.QueryProcessor;
import com.amaap.merchantsguide.repository.GalacticTransactionRepository;
import com.amaap.merchantsguide.service.dto.GalacticQueryDto;
import com.amaap.merchantsguide.service.dto.GalacticTokenDto;
import com.amaap.merchantsguide.service.exception.InvalidGalacticTransactionFound;
import com.amaap.merchantsguide.service.validator.TransactionValidator;

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

    public void resolveQueries() {

        List<GalacticQueryDto> queries = getAllQueries();
        QueryProcessor queryProcessor = new QueryProcessor();
        queryProcessor.processQueries(queries);
    }
}
