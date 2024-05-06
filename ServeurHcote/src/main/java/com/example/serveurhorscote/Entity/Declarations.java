package com.example.serveurhorscote.Entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@Document(collection = "declarations")
public class Declarations implements Serializable {
    @Id
    private String _id;

    private String instrument;
    private Status lastStatus;

    private List<SellersCostumers> sellersCostumers;
    private String brokerSeller;
    private List<SellersCostumers> buyersCostumers;
    private String brokerBuyer;
    private Double quantityExchanged;

    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE_TIME)
    private Date decisionDate;
    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE_TIME)
    private Date depositDate;

    private String codeIsin;

    private Double unitPrice;

    private Double globalVolume;


    private Boolean bis;


        @Getter
        public static class SellersCostumers{
            private String nationality;
        }


}
