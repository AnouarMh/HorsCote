package com.example.serveurhorscote.Entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Setter
@Getter
@Document(collection = "hcTransactionsRealis")
public class HcTransactionsRealis implements Serializable {

    @Id
    private ObjectId _id;


    private String libVal;
    private Double nominal;
    private Double coursPratiq;
    private Double quantite;
    private Double volume;
    private String libIntVt;
    private String libIntAch;

    private String catAvoirCliVt;
    private String catAvoirCliAch;

    private String valGp;
    private Double cnbAch;
    private Double cnbVt;
    private Double rusAch;
    private Double rusVt;










}
