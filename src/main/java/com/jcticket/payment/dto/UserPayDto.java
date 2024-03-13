package com.jcticket.payment.dto;

import lombok.*;

/**
 * packageName    : com.jcticket.payment.dto
 * fileName       : UserPaymentData
 * author         : 조영상
 * date           : 3/13/24
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 3/13/24         조영상        최초 생성
 */
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class UserPayDto {
    private String user_name;
    private String user_tel;
    private String user_address;
}
