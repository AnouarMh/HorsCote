package com.example.apishorscote.Service;

import com.example.apishorscote.Entity.Declarations;
import com.example.apishorscote.Repository.DeclarationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DeclarationsServiceImpl implements DeclarationsService{

    @Autowired
    private DeclarationsRepository declarationsRepository;




    @Override
    public List<Declarations> getDeclarationByDate(Date startDate, Date endDate) {
        return declarationsRepository.findByDecisionDateBetween(startDate,endDate);
    }

    @Override
    public List<Declarations> getDeclarationsBisIsTrue(Date startDate, Date endDate) {
        return declarationsRepository.findByDecisionDateBetweenAndBisIsTrue(startDate,endDate);
    }

    @Override
    public List<Declarations> getDeclarationsByStatusAccepted(Date startDate, Date endDate) {
        return declarationsRepository.findDeclarationsDestinationByDecisionDateBetweenAndStatus(startDate,endDate,"Accepté");
    }

    @Override
    public List<Declarations> getDeclarationsByStatusCanceledReplaced(Date startDate, Date endDate) {

                return declarationsRepository.findDeclarationsDestinationByDecisionDateBetweenAndStatus(startDate,endDate,"Annulé et Remplacé");
    }

    @Override
    public List<Declarations> getDeclarationsByStatusTemporary(Date startDate, Date endDate) {
        return declarationsRepository.findDeclarationsDestinationByDecisionDateBetweenAndStatus(startDate,endDate,"Temporaire");
    }

    @Override
    public List<Declarations> getDeclarationsByStatusSuppression(Date startDate, Date endDate) {
        return declarationsRepository.findDeclarationsDestinationByDecisionDateBetweenAndStatus(startDate,endDate,"Retiré");
    }




}
