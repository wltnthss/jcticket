package com.jcticket.agency.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * packageName    : com.jcticket.agency.controller
 * fileName       : AgencyController
 * author         : {sana}
 * date           : 2024-02-02
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-02        {sana}       최초 생성
 */
@Controller
@RequestMapping("/agency")
public class AgencyController {

    @GetMapping("")
    public String AgencyMain() {
        return "agency/agency";

    }
}
