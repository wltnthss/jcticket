package com.jcticket.viewdetail.dto;

import lombok.*;

import java.sql.Timestamp;

/**
 * packageName    : com.jcticket.viewdetail.dto
 * fileName       : joinDto
 * author         : sungjun
 * date           : 2024-02-14
 * description    : showing, play,
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-14        kyd54       최초 생성
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class JoinDto {
    private String play_name;
    private String play_major_cat;
    private String play_middle_cat;
    private int play_run_time;
    private String play_poster;
    private String play_info;
    private String agency_id;
    private String seat_price;
    private String stage_name;
}


//    private String play_id;
//    private String play_small_cat;
//    private Timestamp created_at;
//    private String created_id;
//    private Timestamp updated_at;
//    private String updated_id;
//    private int seat_grade_seq;
//    private int showing_seq;
//    private Timestamp showing_start_at;
//    private Timestamp showing_end_at;

//    private String showing_day;
//    private String showing_status;
//    private int showing_seat_cnt;
//    private String stage_id;
//    private int seat_seq;
//    private char show_seat_status;
