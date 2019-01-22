package com.desafio.agibank.importalotes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ImportaLotesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImportaLotesApplication.class, args);
    }
}

