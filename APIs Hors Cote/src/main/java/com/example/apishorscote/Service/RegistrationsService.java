package com.example.apishorscote.Service;


import com.example.apishorscote.Entity.Registrations;

import java.util.Date;
import java.util.List;

public interface RegistrationsService {

    List<Registrations> getRegistrationsByDate(Date startDate, Date endDate);

    List<Registrations> getRegistrationsBisIsTrue(Date startDate, Date endDate);

    List<Registrations> getRegistrationsByStatusAccepted(Date startDate, Date endDate);

    List<Registrations> getRegistrationsByStatusCanceledReplaced(Date startDate, Date endDate);

    List<Registrations> getRegistrationsByStatusTemporary(Date startDate, Date endDate);

    List<Registrations> getRegistrationsByStatusSuppression(Date startDate, Date endDate);

}
