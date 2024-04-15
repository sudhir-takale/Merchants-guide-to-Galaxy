package com.amaap.merchantsguide.repository;

import com.amaap.merchantsguide.repository.dto.GalacticQueryDto;
import com.amaap.merchantsguide.domain.model.valueobject.GalacticTranslation;

import java.util.List;

public interface FileRepository {

     boolean save(GalacticQueryDto query);

     boolean saveTranslation(GalacticTranslation token);

     List<GalacticQueryDto> getQueryList();

     List<GalacticTranslation> getAllTranslations();
}
