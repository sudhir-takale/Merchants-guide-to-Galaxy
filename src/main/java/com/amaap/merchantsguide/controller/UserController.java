package com.amaap.merchantsguide.controller;

import com.amaap.merchantsguide.controller.dto.HttpStatus;
import com.amaap.merchantsguide.controller.dto.Response;
import com.amaap.merchantsguide.service.UserService;
import com.amaap.merchantsguide.service.dto.GalacticQueryDto;

import java.util.List;

public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public Response create(List<GalacticQueryDto> queryDtos) {
        this.userService.create(queryDtos);
        return new Response(HttpStatus.OK, "User created");
    }


    public Response processQueries() {
//        this.userService.processQueries();
        return new Response(HttpStatus.OK, "Query processed");
    }
}

