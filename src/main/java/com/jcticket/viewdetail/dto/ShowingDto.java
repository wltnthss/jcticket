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
    private Timestamp showing_start_at;
    private Timestamp showing_end_at;
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
}
