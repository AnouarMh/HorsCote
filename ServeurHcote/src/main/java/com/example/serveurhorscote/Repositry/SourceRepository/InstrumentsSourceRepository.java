package com.example.serveurhorscote.Repositry.SourceRepository;

import com.example.serveurhorscote.Entity.Instruments;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstrumentsSourceRepository extends MongoRepository<Instruments,String> {
}
