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
    private String ticketing_id;
    private Timestamp ticketing_at;
    private int ticketing_cnt;
    private String ticketing_status;
    private String showing_info;
    private String showing_date;
    private Timestamp cancelable_at;
    private int play_price;
    private String stage_name;
    private String choice_show_seat;
    private int ticketing_price;
    private String user_name;
    private Date viewing_at;
    private String play_name;
    private Timestamp created_at;
    private String created_id;
    private Timestamp updated_at;
    private String updated_id;
}
