package com.example.serveurhorscote.Repositry.DestinationRepository;

import com.example.serveurhorscote.Entity.RegistrationsDestination;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RegistrationsDestinationRepository extends MongoRepository<RegistrationsDestination,String> {



}
