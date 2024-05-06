package com.example.serveurhorscote.Repositry.SourceRepository;

import com.example.serveurhorscote.Entity.Registrations;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationsSourceRepository extends MongoRepository<Registrations,String> {
}
