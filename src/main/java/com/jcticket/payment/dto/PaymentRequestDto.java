package com.jcticket.payment.dto;

import lombok.*;

/**
 * packageName    : com.jcticket.payment.dto
 * fileName       : PaymentRequestDto
 * author         : 조영상
 * date           : 3/10/24
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 3/10/24         조영상        최초 생성
 */
@Getter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@Builder
public class PaymentRequestDto {
    private boolean success;
    private String impUid;
    private String payMethod;
    private String merchantUid;
    private String name;
    private int paidAmount;
    private String currency;
    private String pgProvider;
    private String pgType;
    private String pgTid;
    private String applyNum;
    private String buyerName;
    private String buyerEmail;
    private String buyerTel;
    private String buyerAddr;
    private String buyerPostcode;
    private Object customData;
    private String status;
    private int paidAt;
    private String receiptUrl;
    private String cardName;
    private String bankName;
    private int cardQuota;
    private String cardNumber;
}
