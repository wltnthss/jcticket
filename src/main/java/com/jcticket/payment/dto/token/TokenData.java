package com.jcticket.payment.dto.token;

import lombok.*;

/**
 * packageName    : com.jcticket.payment.dto.token
 * fileName       : TockenData
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
public class TokenData {
    private String access_token;
    private long now;
    private long expired_at;
}
