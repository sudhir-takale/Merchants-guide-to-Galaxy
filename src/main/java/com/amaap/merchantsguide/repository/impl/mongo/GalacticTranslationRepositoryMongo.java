package com.amaap.merchantsguide.repository.impl.mongo;

import com.amaap.merchantsguide.domain.model.valueobject.GalacticTranslation;
import com.amaap.merchantsguide.repository.GalacticTranslationRepository;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class GalacticTranslationRepositoryMongo implements GalacticTranslationRepository {

    private final MongoClient mongoClient;

    public GalacticTranslationRepositoryMongo() {
        mongoClient = MongoClients.create("mongodb://localhost:27017");
    }

    @Override
    public void save(GalacticTranslation galacticTranslation) {
        mongoClient.getDatabase("merchantguide").getCollection("translation").insertOne(
                new Document()
                        .append("unit", galacticTranslation.getGalacticUnit())
                        .append("roman", galacticTranslation.getRomanNumeral())
        );
    }

    @Override
    public List<GalacticTranslation> getTranslation() {
        List<GalacticTranslation> translations = new ArrayList<>();

        try {
            MongoCollection<Document> metalCollection = mongoClient
                    .getDatabase("merchantguide")
                    .getCollection("translation");

            FindIterable<Document> findIterable = metalCollection.find();
            for (Document document : findIterable) {
                String metalName = document.getString("name");
                String credit = document.getString("roman");

                if (credit != null && !credit.isEmpty()) {
                    char creditChar = credit.charAt(0);
                    translations.add(new GalacticTranslation(metalName, creditChar));
                } else {
                    translations.add(new GalacticTranslation(metalName, '\0'));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return translations;

    }
}
