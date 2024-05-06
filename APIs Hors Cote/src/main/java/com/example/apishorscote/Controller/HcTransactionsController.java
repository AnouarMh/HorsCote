package com.example.apishorscote.Controller;


import com.example.apishorscote.Entity.HcTransactionsRealis;
import com.example.apishorscote.Service.HcTransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;


@RestController
public class HcTransactionsController {

    @Autowired
    HcTransactionsService hcTransactionsService;


    @GetMapping("/HcTransactionsRealisByDate")
    public List<HcTransactionsRealis> getHcTransactionsRealisByDate(@RequestParam("startDate") @DateTimeFormat(iso= DateTimeFormat.ISO.DATE_TIME) Date startDate, @RequestParam("endDate") @DateTimeFormat(iso= DateTimeFormat.ISO.DATE_TIME) Date endDate){
        return hcTransactionsService.getHcTransactionsRealisByDate(startDate, endDate);
    }
}
