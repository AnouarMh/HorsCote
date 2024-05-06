package com.example.apishorscote.Repository;

import com.example.apishorscote.Entity.Declarations;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface DeclarationsRepository extends MongoRepository<Declarations,String> {

    List<Declarations> findByDecisionDateBetween(Date startDate, Date endDate);

    List<Declarations> findByDecisionDateBetweenAndBisIsTrue(Date startDate,Date endDate);

    List<Declarations> findDeclarationsDestinationByDecisionDateBetweenAndStatus(Date startDate,Date endDate,String status);

}
