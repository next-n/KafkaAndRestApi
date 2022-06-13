package com.example.wiki_recent_changes.controller;

import com.example.wiki_recent_changes.model.Count;
import com.example.wiki_recent_changes.model.Link;
import com.example.wiki_recent_changes.service.ChangesDataService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/")
//@ComponentScan(value = "com.example.saveallrecentchanges.service.*")
public class Recent_changes_controller {

    private ChangesDataService changesDataService;

    @GetMapping(value = "count")
    public Count getCount(){
        return changesDataService.getCounts();
    }
    @GetMapping("getLink/{n}")
    public Link getLink(@PathVariable("n") long n){
        return changesDataService.getLink(n);
    }
}
