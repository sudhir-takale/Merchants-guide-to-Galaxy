package com.amaap.merchantsguide.repository;

import com.amaap.merchantsguide.domain.model.entity.Metal;

import java.util.List;

public interface MetalRepository {
    void add(Metal newMetal);

    List<Metal> getMetals();

}
