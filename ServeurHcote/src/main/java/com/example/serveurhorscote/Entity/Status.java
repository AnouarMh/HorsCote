package com.example.serveurhorscote.Entity;

import lombok.Getter;
import org.springframework.data.annotation.Id;


@Getter
public class Status  {
    @Id
    private String _id;

    private String statusFrName;

}
