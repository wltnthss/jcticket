package com.jcticket.payment.dto;

import lombok.*;

/**
 * packageName    : com.jcticket.payment.dto
 * fileName       : PaymentPrepareDto
 * author         : 조영상
 * date           : 3/11/24
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 3/11/24         조영상        최초 생성
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class PaymentPrepareDto {
    private String merchantUid;
    private int amount;
}
