package com.example.serveurhorscote.Repositry.SourceRepository;

import com.example.serveurhorscote.Entity.HcTransactionsRealis;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HcTransactionsRealisSourceRepository extends MongoRepository<HcTransactionsRealis,Class> {
}
