package com.amaap.merchantsguide.service;

import com.amaap.merchantsguide.domain.model.entity.Metal;
import com.amaap.merchantsguide.repository.MetalRepositoryImpl;
import com.google.inject.Inject;

public class MetalService {
    private final MetalRepositoryImpl metalRepositoryImpl;

    @Inject
    public MetalService(MetalRepositoryImpl metalRepositoryImpl) {
        this.metalRepositoryImpl = metalRepositoryImpl;
    }

    public boolean create(String metal, double credit) {
        if (metal.isEmpty() || credit < 0) return false;
        Metal newMetal = new Metal(metal, credit);
        metalRepositoryImpl.add(newMetal);
        return true;
    }
}
