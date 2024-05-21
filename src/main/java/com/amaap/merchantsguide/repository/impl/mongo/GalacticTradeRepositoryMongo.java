package com.amaap.merchantsguide.repository.impl.mongo;

import com.amaap.merchantsguide.domain.model.entity.GalacticTrade;
import com.amaap.merchantsguide.domain.model.entity.Metal;
import com.amaap.merchantsguide.domain.model.valueobject.GalacticTranslation;
import com.amaap.merchantsguide.repository.GalacticTradeRepository;
import com.amaap.merchantsguide.repository.dto.GalacticQueryDto;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.bson.Document;

import java.util.List;

public class GalacticTradeRepositoryMongo implements GalacticTradeRepository {

    private final MongoClient mongoClient;

    public GalacticTradeRepositoryMongo() {
        mongoClient = MongoClients.create("mongodb://localhost:27017");
    }

    @Override
    public int saveTransaction(GalacticTrade galacticTrade) {
        mongoClient.getDatabase("merchantguide").getCollection("query").insertOne(
                new Document()

                        .append("credits", galacticTrade.getCredit())
                        .append("metal", galacticTrade.getMetal())
                        .append("transactionName", galacticTrade.getTransactionName())
        );
        return 1;

    }

    @Override
    public List<GalacticTrade> getTransactions() {
        return List.of();
    }

    @Override
    public List<GalacticQueryDto> getAllQueries() {
        return List.of();
    }

    @Override
    public List<GalacticTranslation> getTranslationDto() {
        return List.of();
    }

    @Override
    public void createQuery(String query) {

    }

    @Override
    public List<Metal> getMetals() {
        return List.of();
    }
}
