package com.example.wiki_recent_changes.config;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ProducerConf {

    private final static Logger logger = LoggerFactory.getLogger(ProducerConf.class);
//    @Value("spring.kafka.producer.bootstrap-servers")
//    private String BootStrap;

    @Bean
    public Map<String, Object> produce(){
        Map<String, Object> produceConfig = new HashMap<String, Object>();
        produceConfig.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        produceConfig.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        produceConfig.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        return produceConfig;
    }
    @Bean
    public ProducerFactory producerFactory(){
        return new DefaultKafkaProducerFactory(produce());

    }

    @Bean
    public KafkaTemplate<String, String> kafkaTemplate() {
        logger.info("Kafa introduced");
        return new KafkaTemplate<String, String>(producerFactory());
    }




}
