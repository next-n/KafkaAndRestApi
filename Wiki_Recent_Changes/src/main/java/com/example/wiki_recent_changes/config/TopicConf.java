package com.example.wiki_recent_changes.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
@Configuration
public class TopicConf {
    @Bean
    public NewTopic topic(){
        return TopicBuilder.name("savechanges").build();
    }
}
