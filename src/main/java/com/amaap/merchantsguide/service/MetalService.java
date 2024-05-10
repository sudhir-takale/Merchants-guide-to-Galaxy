package com.amaap.merchantsguide.service;

import com.amaap.merchantsguide.domain.model.entity.Metal;
import com.amaap.merchantsguide.repository.MetalRepositoryImpl;
import com.amaap.merchantsguide.service.exception.InValidMetalFoundException;
import com.google.inject.Inject;

public class MetalService {
    private final MetalRepositoryImpl metalRepositoryImpl;

    @Inject
    public MetalService(MetalRepositoryImpl metalRepositoryImpl) {
        this.metalRepositoryImpl = metalRepositoryImpl;
    }

    public boolean create(String metal, double credit) throws InValidMetalFoundException {
        if (metal.isEmpty() || credit < 0) throw new InValidMetalFoundException("Invalid metal");
        Metal newMetal = new Metal(metal, credit);
        metalRepositoryImpl.add(newMetal);
        return true;
    }
}
