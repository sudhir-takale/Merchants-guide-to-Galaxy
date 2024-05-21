package com.amaap.merchantsguide;

import com.amaap.merchantsguide.repository.GalacticTradeRepository;
import com.amaap.merchantsguide.repository.GalacticTranslationRepository;
import com.amaap.merchantsguide.repository.MetalRepository;
import com.amaap.merchantsguide.repository.impl.mongo.GalacticTradeRepositoryMongo;
import com.amaap.merchantsguide.repository.impl.mongo.GalacticTranslationRepositoryMongo;
import com.amaap.merchantsguide.repository.impl.mongo.MetalRepositoryMongo;
import com.google.inject.AbstractModule;

public class MerchantModule extends AbstractModule {

    @Override
    public void configure() {
        bind(GalacticTranslationRepository.class).to(GalacticTranslationRepositoryMongo.class);
        bind(GalacticTradeRepository.class).to(GalacticTradeRepositoryMongo.class);
        bind(MetalRepository.class).to(MetalRepositoryMongo.class);
    }


}
