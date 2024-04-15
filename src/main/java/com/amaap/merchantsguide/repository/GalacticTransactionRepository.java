package com.amaap.merchantsguide.repository;

import com.amaap.merchantsguide.domain.model.entity.GalacticTransaction;
import com.amaap.merchantsguide.repository.dto.GalacticQueryDto;
import com.amaap.merchantsguide.domain.model.valueobject.GalacticTranslation;

import java.util.List;

public interface GalacticTransactionRepository {
    int saveTransaction(GalacticTransaction galacticTransaction);

    List<GalacticTransaction> getTransactions();

    List<GalacticQueryDto> getAllQueries();

    List<GalacticTranslation> getTranslationDto();
}
