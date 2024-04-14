package com.amaap.merchantsguide.repository;

import com.amaap.merchantsguide.service.dto.GalacticQueryDto;
import com.amaap.merchantsguide.service.dto.GalacticTokenDto;

import java.util.List;

public interface FileRepository {

     boolean save(GalacticQueryDto query);

     boolean saveTranslation(GalacticTokenDto token);

     List<GalacticQueryDto> getQueryList();

     List<GalacticTokenDto> getAllTranslations();
}
