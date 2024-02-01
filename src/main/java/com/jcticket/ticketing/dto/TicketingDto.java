package com.jcticket.ticketing.dto;

import lombok.*;

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
@RequiredArgsConstructor
public class TicketingDto {
    private int ticketingId;
    private Date ticketingAt;
    @NonNull
    private int ticketingCnt;
    private String ticketingStatus;
    @NonNull
    private String showingInfo;
    @NonNull
    private String showingDate;
    private Date cancelableDate;
    @NonNull
    private String playName;
    @NonNull
    private String playPrice;
    @NonNull
    private String stageName;
    @NonNull
    private String choiceShowSeat;
    @NonNull
    private String ticketingPrice;
    @NonNull
    private String userName;
    private Date viewingAt;
}
