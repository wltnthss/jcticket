package com.jcticket.mypage.dto;

import lombok.*;

import java.sql.Timestamp;

/**
 * packageName    : com.jcticket.mypage.dto
 * fileName       : UserCouponDto
 * author         : JJS
 * date           : 2024-02-26
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-26        JJS       최초 생성
 */

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserCouponDto {

        private Integer user_coupon_seq;
        private String user_id;
        private String coupon_id;
        private Timestamp coupon_use_at; //사용일자
        private Timestamp coupon_issue_at; //발급일
        private Timestamp coupon_expire_at; //만료일자
        private String coupon_use_yn;
        private Timestamp created_at;
        private String created_id;
        private Timestamp updated_at;
        private String updated_id;
        private String coupon_name;
        private Integer coupon_discount_amount;
        private String coupon_use_condition;
        public UserCouponDto(Integer user_coupon_seq, String user_id, String coupon_id, Timestamp coupon_use_at, Timestamp coupon_issue_at, Timestamp coupon_expire_at, String coupon_use_yn, Timestamp created_at, String created_id, Timestamp updated_at, String updated_id) {
                this.user_coupon_seq = user_coupon_seq;
                this.user_id = user_id;
                this.coupon_id = coupon_id;
                this.coupon_use_at = coupon_use_at;
                this.coupon_issue_at = coupon_issue_at;
                this.coupon_expire_at = coupon_expire_at;
                this.coupon_use_yn = coupon_use_yn;
                this.created_at = created_at;
                this.created_id = created_id;
                this.updated_at = updated_at;
                this.updated_id = updated_id;
        }


    }

