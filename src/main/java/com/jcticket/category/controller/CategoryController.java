package com.jcticket.category.controller;

import com.jcticket.category.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

/**
 * packageName    : com.jcticket.category
 * fileName       : CategoryController
 * author         : jinwook Song
 * date           : 2024-02-28
 * description    : 메인 헤더 카테고리별 controller
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-28        jinwook Song       최초 생성
 */
@Controller
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/concert")
    public String concert(Model m) throws Exception {

        List<Map<String, Object>> list = categoryService.selectConcertList();

        m.addAttribute("list",list);

        return "category/concert";
    }

    @GetMapping("/musical")
    public String musical(Model m) throws Exception {

        List<Map<String, Object>> list = categoryService.selectMusicalList();

        System.out.println("list = " + list);

        m.addAttribute("list",list);

        return "category/musical";
    }

    @GetMapping("/play")
    public String play(Model m) throws Exception {

        List<Map<String, Object>> list = categoryService.selectTheaterList();

        m.addAttribute("list",list);

        return "category/play";
    }



    @GetMapping("/classic")
    public String classic(Model m) throws Exception {

        List<Map<String, Object>> list = categoryService.selectClassicList();

        m.addAttribute("list",list);

        return "category/classic";
    }
}
