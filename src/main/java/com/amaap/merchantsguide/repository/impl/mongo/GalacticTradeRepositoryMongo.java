package com.amaap.merchantsguide.repository.impl.mongo;

import com.amaap.merchantsguide.domain.model.entity.GalacticTrade;
import com.amaap.merchantsguide.domain.model.entity.Metal;
import com.amaap.merchantsguide.domain.model.valueobject.GalacticTranslation;
import com.amaap.merchantsguide.repository.GalacticTradeRepository;
import com.amaap.merchantsguide.repository.dto.GalacticQueryDto;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class GalacticTradeRepositoryMongo implements GalacticTradeRepository {

    private final MongoClient mongoClient;

    public GalacticTradeRepositoryMongo() {
        mongoClient = MongoClients.create("mongodb://localhost:27017");
    }

    @Override
    public int saveTransaction(GalacticTrade galacticTrade) {
        mongoClient.getDatabase("merchantguide").getCollection("trades").insertOne(
                new Document()

                        .append("credit", galacticTrade.getCredit())
                        .append("metal", galacticTrade.getMetal())
                        .append("transactionName", galacticTrade.getTransactionName())
        );
        return 1;
    }

    @Override
    public List<GalacticTrade> getTransactions() {
        List<GalacticTrade> trades = new ArrayList<>();

        try {
            MongoCollection<Document> metalCollection = mongoClient
                    .getDatabase("merchantguide")
                    .getCollection("trades");

            FindIterable<Document> findIterable = metalCollection.find();
            for (Document document : findIterable) {
                String name = document.getString("transactionName");
                String metal = document.getString("metal");
                int credit = document.getInteger("credit");
                trades.add(new GalacticTrade(name, metal, credit));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return trades;
    }

    @Override
    public List<GalacticQueryDto> getAllQueries() {
        List<GalacticQueryDto> queries = new ArrayList<>();

        try {
            MongoCollection<Document> metalCollection = mongoClient
                    .getDatabase("merchantguide")
                    .getCollection("queries");

            FindIterable<Document> findIterable = metalCollection.find();
            for (Document document : findIterable) {
                String unit = document.getString("query");
                queries.add(new GalacticQueryDto(unit));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return queries;
    }


    @Override
    public List<GalacticTranslation> getTranslationDto() {
        List<GalacticTranslation> metals = new ArrayList<>();

        try {
            MongoCollection<Document> metalCollection = mongoClient
                    .getDatabase("merchantguide")
                    .getCollection("translation");

            FindIterable<Document> findIterable = metalCollection.find();
            for (Document document : findIterable) {
                String unit = document.getString("unit");
                String roman = document.getString("roman");
                metals.add(new GalacticTranslation(unit, roman.charAt(0)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return metals;
    }

    @Override
    public void createQuery(String query) {
        mongoClient.getDatabase("merchantguide").getCollection("queries").insertOne(
                new Document()

                        .append("query", query)

        );
    }

    @Override
    public List<Metal> getMetals() {
        List<Metal> metals = new ArrayList<>();

        try {
            MongoCollection<Document> metalCollection = mongoClient
                    .getDatabase("merchantguide")
                    .getCollection("trade");

            FindIterable<Document> findIterable = metalCollection.find();
            for (Document document : findIterable) {
                String metalName = document.getString("metal");
                double credit = document.getDouble("credit");
                metals.add(new Metal(metalName, credit));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return metals;
    }
}
