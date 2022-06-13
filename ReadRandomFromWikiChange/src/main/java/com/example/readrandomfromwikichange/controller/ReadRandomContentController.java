package com.example.readrandomfromwikichange.controller;

import com.example.readrandomfromwikichange.model.Count;
import com.example.readrandomfromwikichange.model.Link;
import com.example.readrandomfromwikichange.service.ReadRandomService;
import lombok.AllArgsConstructor;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@RestController
@AllArgsConstructor
public class ReadRandomContentController {
    private static final Logger logger = LoggerFactory.getLogger(ReadRandomContentController.class);
    private ReadRandomService readRandomService;

    private RestTemplate restTemplate;

    @GetMapping("/random")
    public void getRandom(HttpServletResponse response) throws IOException {
          String link = readRandomService.getRandomContent();
//        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(link)).build();
          response.sendRedirect(link);
    }

    @GetMapping("/read")
    public String getAllReadLinks(){
        return readRandomService.getAllRead().stream()
                .map(ReadRandomContentController::change)
                .reduce("", ReadRandomContentController::makeFrontend);
    }

    private static String change(Link ln){
        return "<a href = \"" + ln.getLink() + "\">" + ln.getLink() +"</a>";
    }

    private static String makeFrontend(String a, String b){
        logger.info(a + " " + b);
        return a + "<br>" + b;
    }

}
