package com.amaap.merchantsguide.repository;

import com.amaap.merchantsguide.domain.model.entity.GalacticTrade;
import com.amaap.merchantsguide.domain.model.entity.Metal;
import com.amaap.merchantsguide.repository.dto.GalacticQueryDto;
import com.amaap.merchantsguide.domain.model.valueobject.GalacticTranslation;

import java.util.List;

public interface GalacticTradeRepository {
    int saveTransaction(GalacticTrade galacticTrade);

    List<GalacticTrade> getTransactions();

    List<GalacticQueryDto> getAllQueries();

    List<GalacticTranslation> getTranslationDto();

    void createQuery(String query);

    List<Metal> getMetals();
}
