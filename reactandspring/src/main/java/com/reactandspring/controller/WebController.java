package com.reactandspring.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@EnableAutoConfiguration
public class WebController{

    @RequestMapping("/")
    public String frontPage() {
        return "Welcome to this page";
    }


} 