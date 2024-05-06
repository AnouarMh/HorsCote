package com.example.serveurhorscote.Entity;

import lombok.Getter;
import org.springframework.data.annotation.Id;

@Getter
public class OrderOrigin {
    @Id
    private String _id;

    private String originFrShortLabel;
}
