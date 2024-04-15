package com.amaap.merchantsguide.repository;

import com.amaap.merchantsguide.domain.model.entity.GalacticTransaction;
import com.amaap.merchantsguide.service.dto.GalacticQueryDto;
import com.amaap.merchantsguide.service.dto.GalacticTranslationDto;

import java.util.List;

public interface GalacticTransactionRepository {
    int saveTransaction(GalacticTransaction galacticTransaction);

    List<GalacticTransaction> getTransactions();

    List<GalacticQueryDto> getAllQueries();

    List<GalacticTranslationDto> getTranslationDto();
}
