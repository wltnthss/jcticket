package com.jcticket.ticketing.dto;

import lombok.*;

import java.sql.Timestamp;
import java.util.Date;

/**
 * packageName    : com.jcticket.ticketing.dto
 * fileName       : TicketDto
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
public class TicketingDto {
    private int ticketingId;
    private Timestamp ticketingAt;
    private int ticketingCnt;
    private String ticketingStatus;
    private String showingInfo;
    private String showingDate;
    private Timestamp cancelableDate;
    private String playPrice;
    private String stageName;
    private String choiceShowSeat;
    private String ticketingPrice;
    private String userName;
    private Date viewingAt;
    private String playName;
}
