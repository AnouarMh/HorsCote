package com.example.apishorscote.Controller;


import com.example.apishorscote.Entity.Declarations;
import com.example.apishorscote.Service.DeclarationsService;
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
public class DeclarationsController {
    @Autowired
    DeclarationsService declarationsService;


   @GetMapping("/declarationsByDate")
   private List<Declarations> showDeclarationBydate(@RequestParam("startDate") @DateTimeFormat(iso= DateTimeFormat.ISO.DATE_TIME) Date startDate, @RequestParam("endDate") @DateTimeFormat(iso= DateTimeFormat.ISO.DATE_TIME) Date endDate){
        return declarationsService.getDeclarationByDate(startDate,endDate);
    }

    @GetMapping("/declarationsBisIsTrue")
    private List<Declarations> showDeclarationBisIsTrue(@RequestParam("startDate") @DateTimeFormat(iso= DateTimeFormat.ISO.DATE_TIME) Date startDate, @RequestParam("endDate") @DateTimeFormat(iso= DateTimeFormat.ISO.DATE_TIME) Date endDate){
        return declarationsService.getDeclarationsBisIsTrue(startDate,endDate);
    }

    @GetMapping("/declarationsAccepted")
    private List<Declarations> showDeclarationAccepted(@RequestParam("startDate") @DateTimeFormat(iso= DateTimeFormat.ISO.DATE_TIME) Date startDate, @RequestParam("endDate") @DateTimeFormat(iso= DateTimeFormat.ISO.DATE_TIME) Date endDate) {
        return declarationsService.getDeclarationsByStatusAccepted(startDate, endDate);
    }

    @GetMapping("/declarationsCanceled&Replaced")
    private List<Declarations> showDeclarationCanceled(@RequestParam("startDate") @DateTimeFormat(iso= DateTimeFormat.ISO.DATE_TIME) Date startDate, @RequestParam("endDate") @DateTimeFormat(iso= DateTimeFormat.ISO.DATE_TIME) Date endDate) {
        return declarationsService.getDeclarationsByStatusCanceledReplaced(startDate, endDate);
    }

    @GetMapping("/declarationsTemporary")
    private List<Declarations> showDeclarationTemporary(@RequestParam("startDate") @DateTimeFormat(iso= DateTimeFormat.ISO.DATE_TIME) Date startDate, @RequestParam("endDate") @DateTimeFormat(iso= DateTimeFormat.ISO.DATE_TIME) Date endDate) {
        return declarationsService.getDeclarationsByStatusTemporary(startDate, endDate);
    }

    @GetMapping("/declarationsSuppression")
    private List<Declarations> showDeclarationSuppression(@RequestParam("startDate") @DateTimeFormat(iso= DateTimeFormat.ISO.DATE_TIME) Date startDate, @RequestParam("endDate") @DateTimeFormat(iso= DateTimeFormat.ISO.DATE_TIME) Date endDate) {
        return declarationsService.getDeclarationsByStatusSuppression(startDate, endDate);
    }


}
