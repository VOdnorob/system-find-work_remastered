package com.diploma.projectDiploma.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/welcome")
public class LoginController {

    @GetMapping("/logged")
    public String home(){
        return "Only logged in";
    }

    @GetMapping("/noLogin")
    public String noLogin(){
        return "You are not logged in";
    }
}
