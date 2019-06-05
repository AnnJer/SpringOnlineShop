package com.example.demo.controllers;

import com.example.demo.models.BlockList;
import com.example.demo.models.Session;
import com.example.demo.repositories.ProductRepos;
import com.example.demo.repositories.SessionRepos;
import com.example.demo.repositories.UserRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

@RestController
public class SessionController {

    @Autowired
    private SessionRepos sessionRepos;

    @Autowired
    private UserRepos userRepos;


    public Session getById(@PathVariable(name = "id") Long id) throws ChangeSetPersister.NotFoundException {
        return sessionRepos.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    public void delete(@RequestParam(name = "id") Long id){
        sessionRepos.deleteById(id);
    }


    public void insert(@RequestParam(name = "user_id") Long id,
                       @RequestParam(name = "token") String token){
        sessionRepos.save(new Session(userRepos.findById(id).get(), token));
    }

}
