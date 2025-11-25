package com.forjaerp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync // Importante: Permite que los eventos se procesen en "hilos" separados
public class ForjaErpApplication {
    public static void main(String[] args) {
        SpringApplication.run(ForjaErpApplication.class, args);
    }
}