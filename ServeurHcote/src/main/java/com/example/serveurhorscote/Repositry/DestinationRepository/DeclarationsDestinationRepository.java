package com.example.serveurhorscote.Repositry.DestinationRepository;

import com.example.serveurhorscote.Entity.DeclarationsDestination;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DeclarationsDestinationRepository extends MongoRepository<DeclarationsDestination,String> {



}
