package com.amaap.merchantsguide.repository;

import com.amaap.merchantsguide.domain.model.entity.Metal;
import com.amaap.merchantsguide.repository.db.InMemoryDatabase;

public class MetalRepository {
    private final InMemoryDatabase inMemoryDatabase;

    public MetalRepository(InMemoryDatabase inMemoryDatabase) {
        this.inMemoryDatabase = inMemoryDatabase;
    }

    public void add(Metal newMetal) {
    inMemoryDatabase.saveMetal(newMetal);
    }
}
