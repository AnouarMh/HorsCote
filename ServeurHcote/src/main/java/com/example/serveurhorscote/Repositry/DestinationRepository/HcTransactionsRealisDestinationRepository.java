package com.example.serveurhorscote.Repositry.DestinationRepository;

import com.example.serveurhorscote.Entity.HcTransactionsRealisDestination;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface HcTransactionsRealisDestinationRepository extends MongoRepository<HcTransactionsRealisDestination, Date> {

}
