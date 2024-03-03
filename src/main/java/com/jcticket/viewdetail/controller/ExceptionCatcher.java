package com.jcticket.viewdetail.controller;

import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ValidationException;
import java.io.IOException;
import java.sql.SQLException;

/**
 * packageName    : com.jcticket.viewdetail.controller
 * fileName       : ExceptionCatcher
 * author         : sungjun
 * date           : 2024-02-20
 * description    : 예외처리
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-20        kyd54       최초 생성
 */
// ControllerAdvice어노테이션 꼭 추가해줘야함
@ControllerAdvice
public class ExceptionCatcher {
    //배열로 만들면 메소드를 여러개 만들 필요가 없다
    @ExceptionHandler({Exception.class,NullPointerException.class,
            SQLException.class, ValidationException.class, IllegalStateException.class,
            IllegalArgumentException.class, IOException.class, HttpMessageNotReadableException.class})

    public String catcher(Exception e, Model model) {
        model.addAttribute("error",e);
        return "viewdetail/error";
    }

//    @ExceptionHandler(NullPointerException.class)
//    public String catcher_null(Exception e,Model model) {
//        model.addAttribute("error",e);
//        return "viewdetail/error";
//    }
}
