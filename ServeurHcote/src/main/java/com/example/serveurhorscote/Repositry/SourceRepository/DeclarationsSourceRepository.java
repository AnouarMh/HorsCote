package com.example.serveurhorscote.Repositry.SourceRepository;

import com.example.serveurhorscote.Entity.Declarations;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeclarationsSourceRepository extends MongoRepository<Declarations,String> {
}
