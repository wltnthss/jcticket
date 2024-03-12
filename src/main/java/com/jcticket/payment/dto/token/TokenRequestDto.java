package com.jcticket.payment.dto.token;

import lombok.*;

/**
 * packageName    : com.jcticket.payment.dto.token
 * fileName       : TokenRequestDto
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
public class TokenRequestDto {
    private String imp_key;
    private String imp_secret;
}
