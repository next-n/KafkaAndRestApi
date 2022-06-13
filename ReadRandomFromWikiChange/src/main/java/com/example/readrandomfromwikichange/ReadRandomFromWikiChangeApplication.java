package com.example.readrandomfromwikichange;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ReadRandomFromWikiChangeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReadRandomFromWikiChangeApplication.class, args);
    }

}
