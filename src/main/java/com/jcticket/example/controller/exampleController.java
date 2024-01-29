package com.jcticket.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * packageName :  com.jcticket.example.controller
 * fileName : exampleController
 * author :  jisoo Son
 * date : 2024-01-29
 * description : Css, Code Template 생성
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2024-01-29             jisoo Son             최초 생성
 */
@Controller
public class exampleController {

    @GetMapping("/example")
    public String example(){
        return "example";
    }
}