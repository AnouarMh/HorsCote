package com.example.serveurhorscote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ServeurHorsCoteApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServeurHorsCoteApplication.class, args);
    }

}
