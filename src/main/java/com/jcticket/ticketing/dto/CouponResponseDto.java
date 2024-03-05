package com.jcticket.ticketing.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
public class CouponResponseDto {
    private String couponName;
    private int couponDiscount;
    private int minOrder;
    private String description;
    private String couponUseableStartDate;
    private String couponUseableEndDate;
}
