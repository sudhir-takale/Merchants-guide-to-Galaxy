package com.amaap.merchantsguide.repository.impl;

import com.amaap.merchantsguide.repository.FileRepository;
import com.amaap.merchantsguide.repository.db.InMemoryDatabase;
import com.amaap.merchantsguide.service.dto.GalacticQueryDto;
import com.amaap.merchantsguide.service.dto.GalacticTokenDto;

import java.util.List;

public class FileRepositoryImpl implements FileRepository {
    private InMemoryDatabase inMemoryDatabase;

    public FileRepositoryImpl(InMemoryDatabase inMemoryDatabase) {
        this.inMemoryDatabase = inMemoryDatabase;
    }

    @Override
    public boolean save(GalacticQueryDto query) {

        this.inMemoryDatabase.insert(query);
        return true;
    }

    @Override
    public boolean saveTranslation(GalacticTokenDto token) {
        this.inMemoryDatabase.save(token);
        return true;
    }

    @Override
    public List<GalacticQueryDto> getQueryList() {
        return inMemoryDatabase.getQueryList();
    }

    @Override
    public List<GalacticTokenDto> getAllTranslations() {
        return inMemoryDatabase.getAllTranslations();
    }

}
