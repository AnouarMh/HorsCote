package com.example.apishorscote.Service;


import com.example.apishorscote.Entity.Registrations;
import com.example.apishorscote.Repository.RegistrationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class RegistrationsServiceImpl implements RegistrationsService{
   @Autowired
   RegistrationsRepository registrationsRepository;



    @Override
    public List<Registrations> getRegistrationsByDate(Date startDate, Date endDate) {
        return registrationsRepository.findRegistrationsDestinationByDecisionDateBetween(startDate,endDate);
    }

    @Override
    public List<Registrations> getRegistrationsBisIsTrue(Date startDate, Date endDate) {
        return registrationsRepository.findRegistrationsDestinationByDecisionDateBetweenAndBisIsTrue(startDate, endDate);
    }

    @Override
    public List<Registrations> getRegistrationsByStatusAccepted(Date startDate, Date endDate) {
        return registrationsRepository.findRegistrationsDestinationByDecisionDateBetweenAndStatus(startDate,endDate,"Accepté");
    }

    @Override
    public List<Registrations> getRegistrationsByStatusCanceledReplaced(Date startDate, Date endDate) {
        return registrationsRepository.findRegistrationsDestinationByDecisionDateBetweenAndStatus(startDate,endDate,"Annulé et Remplacé");
    }

    @Override
    public List<Registrations> getRegistrationsByStatusTemporary(Date startDate, Date endDate) {
        return registrationsRepository.findRegistrationsDestinationByDecisionDateBetweenAndStatus(startDate,endDate,"Temporaire");
    }

    @Override
    public List<Registrations> getRegistrationsByStatusSuppression(Date startDate, Date endDate) {
        return registrationsRepository.findRegistrationsDestinationByDecisionDateBetweenAndStatus(startDate,endDate,"Retiré");
    }

}
