package com.example.readrandomfromwikichange.service;

import com.example.readrandomfromwikichange.model.Count;
import com.example.readrandomfromwikichange.model.Link;
import com.example.readrandomfromwikichange.model.ReadLinkDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;

@Service
@AllArgsConstructor
public class ReadRandomService {
    private RestTemplate restTemplate;
    private ReadLinkDao readLinkDao;

//    public long getCount(){
//        String link = "http://localhost:8080/api/count";
//        Count c = restTemplate.getForObject(link, Count.class);
//        return c.getCount();
//
//
//    }

    public String getRandomContent(){
        String lik = "http://RECENTCHANGES/api/count";
        Count c = restTemplate.getForObject(lik, Count.class);
        long l = c.getCount();

        Random r = new Random();
        long low = 1;
        long high = l;
        long result = r.nextLong(high-low) + low;
        Link link = restTemplate.getForObject("http://RECENTCHANGES/api/getLink/" + result, Link.class);
        readLinkDao.save(link);
        return link.getLink();
//        return String.valueOf(l);
    }

    public List<Link> getAllRead(){
        return readLinkDao.findAll();
    }
}
