package com.jcticket.ticketing.dto;

import lombok.*;

import java.util.Date;

/**
 * packageName    : com.jcticket.ticketing.dto
 * fileName       : CouponResponseDto
 * author         : 조영상
 * date           : 3/6/24
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 3/6/24         조영상        최초 생성
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CouponResponseDto {
    private String userCouponId;
    private String couponName;
    private int couponDiscount;
    private int minOrder;
    private String discription;
    private String useCondition;
    private String couponUseableStartDate;
    private String couponUseableEndDate;
}
