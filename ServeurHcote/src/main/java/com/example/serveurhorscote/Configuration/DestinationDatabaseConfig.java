package com.example.serveurhorscote.Configuration;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;



@Configuration
@EnableMongoRepositories(basePackages = "com.example.serveurhorscote.Repositry.DestinationRepository",
        mongoTemplateRef = "destinationMongoTemplate")
public class DestinationDatabaseConfig {

    @Bean(name = "destinationMongoTemplate")
    public MongoOperations destinationMongoTemplate() {
        return new MongoTemplate(secondaryMongoClient(), "bvmthorscote");
    }

    @Bean
    public MongoClient secondaryMongoClient() {
        return MongoClients.create("mongodb://localhost:27017/bvmthorscote");
    }

}