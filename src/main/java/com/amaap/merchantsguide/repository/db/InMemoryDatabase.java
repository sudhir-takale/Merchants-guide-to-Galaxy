package com.amaap.merchantsguide.repository.db;

import com.amaap.merchantsguide.domain.model.entity.GalacticTransaction;
import com.amaap.merchantsguide.repository.dto.GalacticQueryDto;
import com.amaap.merchantsguide.domain.model.valueobject.GalacticTranslation;

import java.util.List;

public interface InMemoryDatabase {

     void save(GalacticTranslation token);

     void insert(GalacticQueryDto query);

     List<GalacticQueryDto> getQueryList();

     List<GalacticTranslation> getAllTranslations();
     List<GalacticTransaction> getTransactions();

     void addTransaction(GalacticTransaction galacticTransaction);


}
