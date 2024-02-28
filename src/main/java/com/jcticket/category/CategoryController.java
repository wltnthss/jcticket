package com.jcticket.category;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * packageName    : com.jcticket.category
 * fileName       : CategoryController
 * author         : jinwook Song
 * date           : 2024-02-28
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-28        jinwook Song       최초 생성
 */
@Controller
public class CategoryController {

    @GetMapping("/concert")
    public String concert(){

        return "category/concert";
    }

    @GetMapping("/play")
    public String play(){

        return "category/play";
    }

    @GetMapping("/musical")
    public String musical(){

        return "category/musical";
    }

    @GetMapping("/classic")
    public String classic(){

        return "category/classic";
    }
}
