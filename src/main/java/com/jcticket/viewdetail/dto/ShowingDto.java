package com.jcticket.viewdetail.dto;

import lombok.*;

import java.sql.Timestamp;

/**
 * packageName    : com.jcticket.viewdetail.dto
 * fileName       : showingDto
 * author         : sungjun
 * date           : 2024-02-05
 * description    : 회차 Dto
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-05        kyd54       최초 생성
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class ShowingDto {
    private int showing_seq;
    private String showing_start_at;
    private String showing_end_at;
    private String showing_info;
    private String showing_date;
    private String showing_day;
    private String showing_status;
    private int showing_seat_cnt;
    private String play_id;
    private String stage_id;
    private Timestamp created_at;
    private String created_id;
    private Timestamp updated_at;
    private String updated_id;

    public ShowingDto(String showing_info, String showing_date, String showing_day, String showing_status, int showing_seat_cnt, String play_id, String stage_id, String created_id, String updated_id){
        this.showing_info = showing_info;
        this.showing_date = showing_date;
        this.showing_day = showing_day;
        this.showing_status = showing_status;
        this.showing_seat_cnt = showing_seat_cnt;
        this.play_id = play_id;
        this.stage_id = stage_id;
        this.created_id = created_id;
        this.updated_id = updated_id;
    }
    public ShowingDto(int showing_seq, String showing_info, String showing_date, String showing_day, String showing_status, int showing_seat_cnt, String play_id, String stage_id, String created_id, String updated_id){
        this.showing_seq = showing_seq;
        this.showing_info = showing_info;
        this.showing_date = showing_date;
        this.showing_day = showing_day;
        this.showing_status = showing_status;
        this.showing_seat_cnt = showing_seat_cnt;
        this.play_id = play_id;
        this.stage_id = stage_id;
        this.created_id = created_id;
        this.updated_id = updated_id;
    }
}
