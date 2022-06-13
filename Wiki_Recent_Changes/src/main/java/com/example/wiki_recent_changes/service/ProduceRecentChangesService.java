package com.example.wiki_recent_changes.service;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.net.URI;

@Service
@Data
@Builder

@AllArgsConstructor
@ComponentScan(value = "com.example.Recentchanges.*")
public class ProduceRecentChangesService {
    private final static Logger logger = LoggerFactory.getLogger(ProduceRecentChangesService.class);

    private KafkaTemplate<String, String> kafkaTemplate;


    public void send(){
        logger.info("logservice" + kafkaTemplate);
        String topic = "savechanges";
        String uri = "https://stream.wikimedia.org/v2/stream/recentchange";
        EventHandler handler = new RecentEventsHandler(topic, kafkaTemplate);
        EventSource.Builder eventbuilder = new EventSource.Builder(handler, URI.create(uri));
        EventSource eventSource = eventbuilder.build();
        eventSource.start();

    }


}
