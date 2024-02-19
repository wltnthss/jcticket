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
    private String user_id;
    private Timestamp viewing_at; //TimeStamp로 바꿔야하나??
    private String play_name;
    private Timestamp created_at;
    private String created_id;
    private Timestamp updated_at;
    private String updated_id;
    private String play_middle_cat;


    public TicketingDto(String ticketing_id, Timestamp ticketing_at, int ticketing_cnt, String ticketing_status,
                        String showing_info, String showing_date, Timestamp cancelable_at, int play_price, String stage_name,
                        String choice_show_seat, int ticketing_price, String user_name, String user_id, Timestamp viewing_at, String play_name,
                        Timestamp created_at, String created_id, Timestamp updated_at, String updated_id) {
        this.ticketing_id = ticketing_id;
        this.ticketing_at = ticketing_at;
        this.ticketing_cnt = ticketing_cnt;
        this.ticketing_status = ticketing_status;
        this.showing_info = showing_info;
        this.showing_date = showing_date;
        this.cancelable_at = cancelable_at;
        this.play_price = play_price;
        this.stage_name = stage_name;
        this.choice_show_seat = choice_show_seat;
        this.ticketing_price = ticketing_price;
        this.user_name = user_name;
        this.user_id = user_id;
        this.viewing_at = viewing_at;
        this.play_name = play_name;
        this.created_at = created_at;
        this.created_id = created_id;
        this.updated_at = updated_at;
        this.updated_id = updated_id;
    }
}


