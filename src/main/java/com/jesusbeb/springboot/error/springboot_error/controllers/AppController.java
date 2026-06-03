package com.jesusbeb.springboot.error.springboot_error.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {


    @GetMapping("/app")
    public String index() {
        
        return "ok 200";
    }
}
