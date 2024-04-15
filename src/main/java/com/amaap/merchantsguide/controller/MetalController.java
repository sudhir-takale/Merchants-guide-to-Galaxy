package com.amaap.merchantsguide.controller;

import com.amaap.merchantsguide.service.MetalService;

public class MetalController {
    private MetalService metalService;

    public MetalController(MetalService metalService) {
        this.metalService = metalService;
    }

    public boolean create(String metal, int credit) {
        return metalService.create(metal, credit);
    }
}
