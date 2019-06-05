package com.example.demo.controllers;

import com.example.demo.models.User;
import com.example.demo.repositories.UserRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    @Autowired
    private UserRepos userRepos;

    @PostMapping("/log_in")
    @RequestMapping(method = RequestMethod.GET)
    public String loginPage(Model model){
        return "login";
    }



}
