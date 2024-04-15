package com.amaap.merchantsguide.repository.db;

import com.amaap.merchantsguide.domain.model.entity.GalacticTransaction;
import com.amaap.merchantsguide.domain.model.entity.User;
import com.amaap.merchantsguide.service.dto.GalacticQueryDto;
import com.amaap.merchantsguide.service.dto.GalacticTranslationDto;

import java.util.List;

public interface InMemoryDatabase {

     void save(GalacticTranslationDto token);

     void insert(GalacticQueryDto query);

     List<GalacticQueryDto> getQueryList();

     List<GalacticTranslationDto> getAllTranslations();
     List<GalacticTransaction> getTransactions();

     void addTransaction(GalacticTransaction galacticTransaction);

     void insertUser(User user);
}
