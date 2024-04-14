package com.amaap.merchantsguide.repository;

import com.amaap.merchantsguide.domain.model.entity.User;
import com.amaap.merchantsguide.repository.db.InMemoryDatabase;
import com.amaap.merchantsguide.service.dto.GalacticQueryDto;

import java.util.List;

public class UserRepository {
    private InMemoryDatabase inMemoryDatabase;

    public UserRepository(InMemoryDatabase inMemoryDatabase) {
        this.inMemoryDatabase = inMemoryDatabase;
    }

    public List<GalacticQueryDto> getQueryDtoList() {
        return this.inMemoryDatabase.getQueryList();
    }

    public void save(User user) {
        this.inMemoryDatabase.insertUser(user);
    }
}
