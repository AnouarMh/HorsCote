package com.example.serveurhorscote.Controller;


import com.example.serveurhorscote.Service.HcTransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
public class HcTransactionsController {

    @Autowired
    HcTransactionsService hcTransactionsService;

    @GetMapping("/transferHcTransactionsRealis")
    public ResponseEntity<String> transferDataHcTransactionsRealis() {
        try {
            hcTransactionsService.TransferHcTransactionsRealis();
            return ResponseEntity.ok("Data transfer successful.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred during data transfer.");
        }
    }


}
