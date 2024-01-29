package com.jcticket.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class exampleController {

    @GetMapping("/example")
    public String example(){
        return "example";
    }
}
