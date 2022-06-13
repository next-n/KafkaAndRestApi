package com.example.wiki_recent_changes.service;

import com.example.wiki_recent_changes.model.Count;
import com.example.wiki_recent_changes.model.Link;
import com.example.wiki_recent_changes.model.Recent_changes_dao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ChangesDataService {
    private Recent_changes_dao recent_changes_dao;

    public Count getCounts(){
        return new Count(recent_changes_dao.count());
    }

    public Link getLink(long n){
        return new Link(recent_changes_dao.getById(n).getAddress());
    }

}
