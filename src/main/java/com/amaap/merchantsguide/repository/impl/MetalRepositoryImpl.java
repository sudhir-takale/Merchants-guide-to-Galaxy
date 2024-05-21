package com.amaap.merchantsguide.repository.impl;

import com.amaap.merchantsguide.domain.model.entity.Metal;
import com.amaap.merchantsguide.repository.MetalRepository;
import com.amaap.merchantsguide.repository.db.InMemoryDatabase;
import com.google.inject.Inject;

import java.util.List;

public class MetalRepositoryImpl implements MetalRepository {
    private final InMemoryDatabase inMemoryDatabase;

    @Inject
    public MetalRepositoryImpl(InMemoryDatabase inMemoryDatabase) {
        this.inMemoryDatabase = inMemoryDatabase;
    }

    @Override
    public void add(Metal newMetal) {
        inMemoryDatabase.saveMetal(newMetal);
    }

    @Override
    public List<Metal> getMetals() {
        return this.inMemoryDatabase.getMetals();
    }
}
