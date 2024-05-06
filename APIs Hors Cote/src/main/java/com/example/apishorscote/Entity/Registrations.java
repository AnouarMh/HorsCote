package com.example.apishorscote.Entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Document(collection = "registrations")
public class Registrations implements Serializable {

    @Id
    private String nOrdre;

    private String instrument;
    private String sellerNationality;
    private String brokerSeller;
    private String buyerNationality;
    private String brokerBuyer;
    private Double quantityExchanged;

    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE_TIME)
    private Date decisionDate;
    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE_TIME)
    private Date depositDate;

    private Double lastNominal;
    private Double unitPrice;
    private Double globalVolume;
    private String group;
    private Double sellCeb;
    private Double buyCeb;
    private Double sellRus;
    private Double buyRus;
    private Double globalCeb;
    private Double globalRus;
    private String status;

    private Boolean bis;
}
