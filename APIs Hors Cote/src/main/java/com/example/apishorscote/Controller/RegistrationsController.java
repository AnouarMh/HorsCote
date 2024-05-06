package com.example.apishorscote.Controller;


import com.example.apishorscote.Entity.Registrations;
import com.example.apishorscote.Service.RegistrationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;


@RestController
public class RegistrationsController {
    @Autowired
    RegistrationsService registrationsService;



    @GetMapping("/registrationsByDate")
    private List<Registrations> showRegistrationsBydate(@RequestParam("startDate") @DateTimeFormat(iso= DateTimeFormat.ISO.DATE_TIME) Date startDate, @RequestParam("endDate") @DateTimeFormat(iso= DateTimeFormat.ISO.DATE_TIME) Date endDate){
        return registrationsService.getRegistrationsByDate(startDate,endDate);
    }

    @GetMapping("/registrationsBisIsTrue")
    private List<Registrations> showRegistrationsBisIsTrue(@RequestParam("startDate") @DateTimeFormat(iso= DateTimeFormat.ISO.DATE_TIME) Date startDate, @RequestParam("endDate") @DateTimeFormat(iso= DateTimeFormat.ISO.DATE_TIME) Date endDate){
        return registrationsService.getRegistrationsBisIsTrue(startDate,endDate);
    }

    @GetMapping("/registrationsAccepted")
    private List<Registrations> showRegistrationsAccepted(@RequestParam("startDate") @DateTimeFormat(iso= DateTimeFormat.ISO.DATE_TIME) Date startDate, @RequestParam("endDate") @DateTimeFormat(iso= DateTimeFormat.ISO.DATE_TIME) Date endDate) {
        return registrationsService.getRegistrationsByStatusAccepted(startDate, endDate);
    }

    @GetMapping("/registrationsCanceled&Replaced")
    private List<Registrations> showRegistrationsCanceled(@RequestParam("startDate") @DateTimeFormat(iso= DateTimeFormat.ISO.DATE_TIME) Date startDate, @RequestParam("endDate") @DateTimeFormat(iso= DateTimeFormat.ISO.DATE_TIME) Date endDate) {
        return registrationsService.getRegistrationsByStatusCanceledReplaced(startDate, endDate);
    }

    @GetMapping("/registrationsTemporary")
    private List<Registrations> showRegistrationsTemporary(@RequestParam("startDate") @DateTimeFormat(iso= DateTimeFormat.ISO.DATE_TIME) Date startDate, @RequestParam("endDate") @DateTimeFormat(iso= DateTimeFormat.ISO.DATE_TIME) Date endDate) {
        return registrationsService.getRegistrationsByStatusTemporary(startDate, endDate);
    }

    @GetMapping("/registrationsSuppression")
    private List<Registrations> showRegistrationsSuppression(@RequestParam("startDate") @DateTimeFormat(iso= DateTimeFormat.ISO.DATE_TIME) Date startDate, @RequestParam("endDate") @DateTimeFormat(iso= DateTimeFormat.ISO.DATE_TIME) Date endDate) {
        return registrationsService.getRegistrationsByStatusSuppression(startDate, endDate);
    }
}
