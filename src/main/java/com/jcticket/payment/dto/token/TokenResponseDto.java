package com.jcticket.payment.dto.token;

import lombok.*;

import java.util.Iterator;

/**
 * packageName    : com.jcticket.payment.dto.token
 * fileName       : TokenResponseDto
 * author         : 조영상
 * date           : 3/11/24
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 3/11/24         조영상        최초 생성
 */
@Getter
@NoArgsConstructor
@ToString
public class TokenResponseDto {
    private Integer code;
    private String message;
    private TokenData response;
}
