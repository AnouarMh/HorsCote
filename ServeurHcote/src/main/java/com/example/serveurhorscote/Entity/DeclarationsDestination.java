package com.example.serveurhorscote.Entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Document(collection = "declarations")
public class DeclarationsDestination implements Serializable {

    @Id
    private String _id;

    private String instrument;
    private String sellersNationality;
    private String brokerSeller;
    private String buyersNationality;
    private String brokerBuyer;
    private Double quantityExchanged;

    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE_TIME)
    private Date decisionDate;
    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE_TIME)
    private Date depositDate;

    private Double lastNominal;

    private Double unitPrice;

    private Double globalVolume;

    private String status;

    private Boolean bis;

}
