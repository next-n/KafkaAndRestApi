package com.example.wiki_recent_changes.service;

import com.example.wiki_recent_changes.model.Recent_changes;
import com.example.wiki_recent_changes.model.Recent_changes_dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service

public class ConsumerService {
    @Autowired
    private Recent_changes_dao recent_changes_dao;
    @KafkaListener(topics = "savechanges", groupId = "groupId")
    void Listener(String data){
        Recent_changes recent_changes = new Recent_changes(0L, data);
        if (data.length() <= 255){
            recent_changes_dao.save(recent_changes);
        }

    }
}
