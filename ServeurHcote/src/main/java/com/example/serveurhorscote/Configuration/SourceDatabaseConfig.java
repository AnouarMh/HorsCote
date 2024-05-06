package com.example.serveurhorscote.Configuration;


import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;



@Configuration
@EnableMongoRepositories(basePackages = "com.example.serveurhorscote.Repositry.SourceRepository",
        mongoTemplateRef = "sourceMongoTemplate")
public class SourceDatabaseConfig {
    @Bean(name = "sourceMongoTemplate")
    public MongoOperations sourceMongoTemplate() {
        return new MongoTemplate(primaryMongoClient(), "horsCote");
    }

    @Bean
    public MongoClient primaryMongoClient() {
        return MongoClients.create("mongodb://localhost:27017/horsCote");
    }
}
