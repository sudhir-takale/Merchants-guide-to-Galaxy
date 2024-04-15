package com.amaap.merchantsguide.service;

import com.amaap.merchantsguide.domain.model.entity.GalacticTransaction;
import com.amaap.merchantsguide.domain.model.entity.User;
import com.amaap.merchantsguide.domain.service.QueryProcessor;
import com.amaap.merchantsguide.repository.UserRepository;
import com.amaap.merchantsguide.service.dto.GalacticQueryDto;

import java.util.List;

public class UserService {
    private UserRepository userRepository;
    private GalacticTransactionService galacticTransactionService;
    private QueryProcessor queryProcessor;

    public UserService(GalacticTransactionService galacticTransactionService, QueryProcessor queryProcessor, UserRepository userRepository) {
        this.galacticTransactionService = galacticTransactionService;
        this.queryProcessor = queryProcessor;
        this.userRepository = userRepository;
    }

    public void create(List<GalacticQueryDto> queryDtos) {
        User user = new User(queryDtos);
        user.setQueryDtoList(getAllQueries());
        userRepository.save(user);
    }

    public List<GalacticQueryDto> getAllQueries() {
        return this.userRepository.getQueryDtoList();
    }

    public List<GalacticTransaction> getAllTransactions() {
        return this.galacticTransactionService.fetchTransactions();
    }



}
