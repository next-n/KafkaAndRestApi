package com.example.wiki_recent_changes;

import com.example.wiki_recent_changes.service.ProduceRecentChangesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class WikiRecentChangesApplication {
    private Logger logger = LoggerFactory.getLogger(WikiRecentChangesApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(WikiRecentChangesApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(ProduceRecentChangesService produceRecentChangesService){
        return args -> {
            logger.info("GET inside");
            System.out.println("HHHUHHU");
            produceRecentChangesService.send();


        };
    }
}
