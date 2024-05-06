package com.example.serveurhorscote.Entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.List;

@Getter
@Setter
public class  Instruments {
    @Id
    private String _id;

    private Double lastNominal;

    private List<Identities> identities;



}
