package com.jcticket.admin.dto;

import lombok.*;

import java.sql.Timestamp;

/**
 * packageName :  com.jcticket.admin.dto
 * fileName : CouponDto
 * author :  jisoo Son
 * date : 2024-02-21
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2024-02-21             jisoo Son             최초 생성
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class CouponDto {
    //    CREATE TABLE `Coupon` (
//            `coupon_id`	VARCHAR(8)	NOT NULL	COMMENT 'UUID 모듈 사용 8자리 난수값',
//            `coupon_reg_at`	TIMESTAMP	NULL	DEFAULT current_timestamp,
//	        `coupon_name`	VARCHAR(30)	NULL	COMMENT '[웰컴 쿠폰] 1000원 할인',
//            `coupon_useable_start_at`	TIMESTAMP	NULL,
//	        `coupon_useable_end_at`	TIMESTAMP	NULL,
//	        `coupon_discount_amount`	INT	NULL	COMMENT '1000',
//            `coupon_min_order_amount`	INT	NULL	COMMENT '[ 20000 ] 원 이상 구매시 input값 20000',
//            `coupon_use_yn`	CHAR(1)	NULL	DEFAULT 'Y'	COMMENT 'N 상태면 사용중지 상태의 쿠폰으로 관리하기 위함',
//            `coupon_status`	VARCHAR(8)	NULL	DEFAULT 'A'	COMMENT '공통코드 A,U,E (사용가능, 사용완료, 유효기간만료)',
//            `coupon_description`	VARCHAR(100)	NULL	COMMENT '중복 쿠폰 사용 불가',
//            `coupon_use_condition`	VARCHAR(100)	NULL	COMMENT 'ex) 20,000 원 이상 구매시 사용 가능',
//            `created_at`	TIMESTAMP	NOT NULL	DEFAULT current_timestamp,
//            `created_id`	VARCHAR(36)	NOT NULL,
//	        `updated_at`	TIMESTAMP	NOT NULL	DEFAULT current_timestamp,
//            `updated_id`	VARCHAR(36)	NOT NULL
//);
    private String coupon_id;                   // 쿠폰 아이디
    private Timestamp coupon_reg_at;               // 쿠폰 등록 일자
    private String coupon_name;                 // 쿠폰명
    private String coupon_useable_start_at;     // 쿠폰 사용 가능 시작 일자
    private String coupon_useable_end_at;       // 쿠폰 사용 가능 종료 일자
    private int coupon_discount_amount;      // 쿠폰 할인 금액
    private int coupon_min_order_amount;     // 쿠폰 최소 주문 금액
    private String coupon_use_yn;               // 쿠폰 사용 여부
    private String coupon_status;               // 쿠폰 상태
    private String coupon_description;          // 쿠폰 설명
    private String coupon_use_condition;        // 쿠폰 사용 조건
    private Timestamp created_at;
    private String created_id;
    private Timestamp updated_at;
    private String updated_id;
}