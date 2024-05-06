package com.example.apishorscote.Entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@Document(collection = "hcTransactionsRealis")
public class HcTransactionsRealis implements Serializable {

    @Id
    @Field("_id")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date _id;

    private String instrument;
    private Double nominal;
    private Double cours;
    private Double quantite;
    private Double volume;
    private String libIntVt;
    private String libIntAch;

    private String catAvoirBuyer;
    private String catAvoirSeller;

    private String groupe;
    private Double cnbSeller;
    private Double cnbBuyer;
    private Double rusSeller;
    private Double rusBuyer;

    private Double cnbGlobal;
    private Double rusGlobal;



}
