package com.amaap.merchantsguide.service;

import com.amaap.merchantsguide.domain.model.entity.Metal;
import com.amaap.merchantsguide.repository.MetalRepository;

public class MetalService {
    private MetalRepository metalRepository;

    public MetalService(MetalRepository metalRepository) {
        this.metalRepository = metalRepository;
    }

    public boolean create(String metal, int credit) {
        Metal newMetal = new Metal(metal, credit);
        metalRepository.add(newMetal);
        return true;
    }
}
