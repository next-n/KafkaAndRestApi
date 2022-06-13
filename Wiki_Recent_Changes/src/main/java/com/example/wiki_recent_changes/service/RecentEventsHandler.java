package com.example.wiki_recent_changes.service;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.MessageEvent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RecentEventsHandler implements EventHandler {
    private static Logger logger = LoggerFactory.getLogger(RecentEventsHandler.class);
    private String topic;
    private KafkaTemplate<String, String> kafkaTemplate;


    @Override
    public void onOpen() throws Exception {

    }

    @Override
    public void onClosed() throws Exception {

    }

    @Override
    public void onMessage(String s, MessageEvent messageEvent) throws Exception {
        String wholeLine = messageEvent.getData();

//        logger.info("event is " + wholeLine)
        String well = "(?<=\"uri\":\")(.*)(?=\",\"re)";

        Pattern p = Pattern.compile(well);
        Matcher matcher = p.matcher(wholeLine);
        if (matcher.find()){

            kafkaTemplate.send(topic, matcher.group(1));


        }

    }

    @Override
    public void onComment(String s) throws Exception {

    }

    @Override
    public void onError(Throwable throwable) {

    }
}
