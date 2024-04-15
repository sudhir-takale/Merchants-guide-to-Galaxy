package com.amaap.merchantsguide.repository;

import com.amaap.merchantsguide.service.dto.GalacticQueryDto;
import com.amaap.merchantsguide.service.dto.GalacticTranslationDto;

import java.util.List;

public interface FileRepository {

     boolean save(GalacticQueryDto query);

     boolean saveTranslation(GalacticTranslationDto token);

     List<GalacticQueryDto> getQueryList();

     List<GalacticTranslationDto> getAllTranslations();
}
