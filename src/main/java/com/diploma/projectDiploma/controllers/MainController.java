package com.diploma.projectDiploma.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/welcome")
public class MainController {

    @GetMapping("/hello")
    public String welcome(){
        return "Hello to our website";
    }

    @GetMapping("/logged")
    public String home(){
        return "Only logged in";
    }
}
