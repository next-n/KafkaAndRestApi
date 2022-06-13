package com.example.kafkaandrestapi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootTest
class KafkaAndRestApiApplicationTests {

    @Test
    void contextLoads() {
        String wl = "{\"$schema\":\"/mediawiki/recentchange/1.0.0\",\"meta\":{\"uri\":\"https://ar.wikipedia.org/wiki/%D8%AA%D8%B5%D9%86%D9%8A%D9%81:%D8%A8%D9%88%D8%A7%D8%A8%D8%A9_%D8%AA%D9%88%D9%86%D8%B3/%D9%85%D9%82%D8%A7%D9%84%D8%A7%D8%AA_%D9%85%D8%AA%D8%B9%D9%84%D9%82%D8%A9\",\"request_id\":\"452d403c-7206-457d-8f88-2afaf35f15f8\",\"id\":\"7203254d-a58d-4430-8651-8b931c79eda9";

        String well = "(?<=\"uri\":\")(.*)(?=\",\"re)";

        Pattern p = Pattern.compile(well);
        Matcher matcher = p.matcher(wl);
        if (matcher.find()){
            System.out.println(matcher.group(1));
        }

    }

}
