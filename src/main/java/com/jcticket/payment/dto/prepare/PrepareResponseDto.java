package com.jcticket.payment.dto.prepare;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * packageName    : com.jcticket.payment.dto.prepare
 * fileName       : PrepareResponseDto
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
public class PrepareResponseDto {
    private Integer code;
    private String message;
    private PrepareData response;
}
