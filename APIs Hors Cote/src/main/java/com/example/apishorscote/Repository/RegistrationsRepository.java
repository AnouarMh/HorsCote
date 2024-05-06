package com.example.apishorscote.Repository;

import com.example.apishorscote.Entity.Registrations;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface RegistrationsRepository extends MongoRepository<Registrations,String> {

    List<Registrations> findRegistrationsDestinationByDecisionDateBetween(Date startDate, Date endDate);

    List<Registrations> findRegistrationsDestinationByDecisionDateBetweenAndBisIsTrue(Date startDate,Date endDate);

    List<Registrations> findRegistrationsDestinationByDecisionDateBetweenAndStatus(Date startDate,Date endDate,String status);

}
