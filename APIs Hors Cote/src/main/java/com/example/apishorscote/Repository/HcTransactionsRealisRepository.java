package com.example.apishorscote.Repository;

import com.example.apishorscote.Entity.HcTransactionsRealis;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface HcTransactionsRealisRepository extends MongoRepository<HcTransactionsRealis, Date> {

    List<HcTransactionsRealis> findHcTransactionsRealisDestinationBy_idBetween(Date startDate, Date endDate);

}
