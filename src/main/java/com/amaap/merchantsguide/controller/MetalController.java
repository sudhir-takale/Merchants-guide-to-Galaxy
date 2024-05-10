package com.amaap.merchantsguide.controller;

import com.amaap.merchantsguide.controller.dto.HttpStatus;
import com.amaap.merchantsguide.controller.dto.Response;
import com.amaap.merchantsguide.service.MetalService;
import com.amaap.merchantsguide.service.exception.InValidMetalFoundException;

public class MetalController {
    private final MetalService metalService;

    public MetalController(MetalService metalService) {
        this.metalService = metalService;
    }

    public Response create(String metal, int credit) throws InValidMetalFoundException {
        try{
            metalService.create(metal, credit);
            return new Response(HttpStatus.OK, "success");
        }
        catch (InValidMetalFoundException e){
            return new Response(HttpStatus.BAD_REQUEST,"failed");
        }
    }
}
