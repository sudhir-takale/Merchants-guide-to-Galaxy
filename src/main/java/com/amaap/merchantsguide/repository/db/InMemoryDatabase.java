package com.amaap.merchantsguide.repository.db;

import com.amaap.merchantsguide.domain.model.entity.GalacticTrade;
import com.amaap.merchantsguide.domain.model.entity.Metal;
import com.amaap.merchantsguide.repository.dto.GalacticQueryDto;
import com.amaap.merchantsguide.domain.model.valueobject.GalacticTranslation;

import java.util.List;

public interface InMemoryDatabase {

     void save(GalacticTranslation token);


     List<GalacticQueryDto> getQueryList();

     List<GalacticTranslation> getAllTranslations();
     List<GalacticTrade> getTransactions();

     void addTransaction(GalacticTrade galacticTrade);


     void saveMetal(Metal newMetal);

     void saveQuery(GalacticQueryDto dto);
}
