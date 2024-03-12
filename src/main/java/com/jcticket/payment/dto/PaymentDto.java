package com.jcticket.payment.dto;

import lombok.*;

import java.sql.Timestamp;

/**
 * packageName    : com.jcticket.payment.dto
 * fileName       : PaymentDto
 * author         : 조영상
 * date           : 1/31/24
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 1/31/24         조영상        최초 생성
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentDto {
    private String payment_id;
    private String payment_approval_id;
    private Integer payment_amount;
    private Timestamp payment_at;
    private String payment_method;
    private String payment_status;
    private String payment_fail_reason;
    private String receipt_url;
    private String ticketing_id;
    private String user_coupon_id;
    private String user_id;
    private Timestamp created_at;
    private String created_id;
    private Timestamp updated_at;
    private String updated_id;
}
