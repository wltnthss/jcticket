package com.jcticket.payment.dto.prepare;

import lombok.*;

import java.math.BigInteger;

/**
 * packageName    : com.jcticket.payment.dto.prepare
 * fileName       : PrepareRequestDto
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
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class PrepareRequestDto {
    private String merchant_uid;
    private Integer amount;
}
