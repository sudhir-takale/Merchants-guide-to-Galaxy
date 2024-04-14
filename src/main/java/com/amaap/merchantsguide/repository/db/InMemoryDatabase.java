package com.amaap.merchantsguide.repository.db;

import com.amaap.merchantsguide.service.dto.GalacticQueryDto;
import com.amaap.merchantsguide.service.dto.GalacticTokenDto;

import java.util.List;

public interface InMemoryDatabase {

     void save(GalacticTokenDto token);


     void insert(GalacticQueryDto query);

     List<GalacticQueryDto> getQueryList();

     List<GalacticTokenDto> getAllTranslations();
}
