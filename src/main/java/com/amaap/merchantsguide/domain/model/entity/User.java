package com.amaap.merchantsguide.domain.model.entity;

import com.amaap.merchantsguide.service.dto.GalacticQueryDto;

import java.util.ArrayList;
import java.util.List;

public class User {

    private int id;
    private List<GalacticQueryDto> queryDtoList;

    public User(List<GalacticQueryDto> queryDtoList) {
        this.queryDtoList = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<GalacticQueryDto> getQueryDtoList() {
        return queryDtoList;
    }

    public void setQueryDtoList(List<GalacticQueryDto> queryDtoList) {
        this.queryDtoList = queryDtoList;
    }
}
