package com.example.serveurhorscote.Entity;

import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Getter
public class ObjectId {
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date sessionDate;

    private String seq;
}
