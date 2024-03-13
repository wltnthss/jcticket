package com.jcticket.payment.dto;

import lombok.*;

/**
 * packageName    : com.jcticket.payment.dto
 * fileName       : PaymentRequestDto
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
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class PaymentRequestDto {
    private boolean success;
    private String imp_uid;
    private String pay_method;
    private String merchant_uid;
    private String name;
    private Integer paid_amount;
    private String currency;
    private String pg_provider;
    private String pg_type;
    private String pg_tid;
    private String apply_num;
    private String buyer_name;
    private String buyer_email;
    private String buyer_tel;
    private String buyer_addr;
    private String buyer_postcode;
    private String custom_data; // user-coupon-id를 받는 필드
    private String status;
    private String paid_at;
    private String receipt_url;
    private String card_name;
    private String bank_name;
    private Integer card_quota;
    private String card_number;

}
