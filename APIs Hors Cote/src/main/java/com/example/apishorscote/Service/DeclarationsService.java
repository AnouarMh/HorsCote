package com.example.apishorscote.Service;


import com.example.apishorscote.Entity.Declarations;

import java.util.Date;
import java.util.List;

public interface DeclarationsService {



    List<Declarations> getDeclarationByDate(Date startDate, Date endDate);

    List<Declarations> getDeclarationsBisIsTrue(Date startDate, Date endDate);

    List<Declarations> getDeclarationsByStatusAccepted(Date startDate, Date endDate);

    List<Declarations> getDeclarationsByStatusCanceledReplaced(Date startDate, Date endDate);

    List<Declarations> getDeclarationsByStatusTemporary(Date startDate, Date endDate);

    List<Declarations> getDeclarationsByStatusSuppression(Date startDate, Date endDate);




}
