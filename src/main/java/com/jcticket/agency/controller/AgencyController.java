package com.jcticket.agency.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Objects;

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
//    @PostMapping("/agencyLogin") // 기획사 로그인 메서드
//    public String agencyLogin(@ModelAttribute("agencyDto") AgencyDto agencyDto, boolean rememberId, Model m,
//                              HttpServletRequest request, HttpServletResponse response) throws Exception {
//        if (!agencyLoginCheck(agencyDto)) {
//            m.addAttribute("agencyDto", agencyDto);
//
//            if (!Objects.equals(agencyDto.getAgency_id(), "") && !Objects.equals(agencyDto.getAgency_password(), "")) {
//                // DB에서 기획사 로그인 가져옴
//                AgencyDto fetchedAgency = agencyDao.selectAgency(agencyDto.getAgency_id());
//                m.addAttribute("agencyDtoPWD", fetchedAgency.getAgency_password());
//                System.out.println("fetchedAgency = " + fetchedAgency);
//            }
//
//            return "redirect:/login";
//        }
//
//        HttpSession session = request.getSession();
//        session.setAttribute("agency_id", agencyDto.getAgency_id());
//
//
//        return "index";
//    }
//
//    private boolean agencyLoginCheck(AgencyDto agencyDto) {
//        AgencyDto fetchedAgency = null;
//        System.out.println("agency_id = " + agencyDto.getAgency_id());
//        System.out.println("agency_pwd = " + agencyDto.getAgency_password());
//        try {
//            fetchedAgency = agencyDao.selectAgency(agencyDto.getAgency_id());
//            System.out.println(fetchedAgency);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return fetchedAgency != null && fetchedAgency.getAgency_password().equals(agencyDto.getAgency_password());
//    }
}
