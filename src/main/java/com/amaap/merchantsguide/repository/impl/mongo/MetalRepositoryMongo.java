package com.amaap.merchantsguide.repository.impl.mongo;

import com.amaap.merchantsguide.domain.model.entity.Metal;
import com.amaap.merchantsguide.repository.MetalRepository;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class MetalRepositoryMongo implements MetalRepository {
    private final MongoClient mongoClient;

    public MetalRepositoryMongo() {
        mongoClient = MongoClients.create("mongodb://localhost:27017");
    }

    @Override
    public void add(Metal newMetal) {
        mongoClient.getDatabase("merchantguide").getCollection("metals").insertOne(
                new Document()

                        .append("metal", newMetal.getMetalName())
                        .append("credit", newMetal.getCredits())
        );
    }

    @Override
    public List<Metal> getMetals() {
        List<Metal> metals = new ArrayList<>();

        try {
            MongoCollection<Document> metalCollection = mongoClient
                    .getDatabase("merchantguide")
                    .getCollection("metals");

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
