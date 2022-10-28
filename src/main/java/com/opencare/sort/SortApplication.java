package com.opencare.sort;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SortApplication {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(SortApplication.class);
        application.run(args);
    }
}
