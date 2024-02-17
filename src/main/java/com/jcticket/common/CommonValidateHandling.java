package com.jcticket.common;

import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.Validator;

import java.util.HashMap;
import java.util.Map;

/**
 * packageName :  com.jcticket.common
 * fileName : validateHandling
 * author :  jisoo Son
 * date : 2024-02-16
 * description : @Valid 객체 에러 결과 Map형식 리턴
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2024-02-16             jisoo Son             최초 생성
 */
public class CommonValidateHandling{
    public Map<String, String> validateHandling(BindingResult bindingResult) {
        Map<String, String> validatorRslt = new HashMap<>();

        // Map 타입 { valid_DTO변수, "오류 메세지" } 리턴
        for (FieldError error : bindingResult.getFieldErrors()) {
            String validKeyName = String.format("valid_%s", error.getField());
            validatorRslt.put(validKeyName, error.getDefaultMessage());
            System.out.println("validatorRslt = " + validatorRslt);
        }

        return validatorRslt;
    }
}