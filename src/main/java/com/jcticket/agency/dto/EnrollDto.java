package com.jcticket.agency.dto;

import lombok.*;
import java.sql.Timestamp;

/**
 * packageName    : com.jcticket.agency.dto
 * fileName       : EnrollDto
 * author         : {sana}
 * date           : 2024-02-14
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-14        {sana}       최초 생성
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class EnrollDto {
    private String play_id; //시스템에서 자동으로 할당되도록? 관리자가 발급?
    private String play_name;
    private String play_poster;
    private String play_info;
    private String play_major_cat;
    private String play_middle_cat;
    private String play_small_cat;
    private int play_run_time;

    private String agency_id;//로그인한 사용자의 기획사 ID세션을 통해 서버에서 처리 되도록

    private Timestamp created_at;// 시스템에서 자동으로 설정되도록
    private String created_id;//로그인세션 이하동문
    private Timestamp updated_at;
    private String updated_id;

    private int showing_seq;
    private Timestamp showing_start_at;
    private Timestamp showing_end_at;
    private String showing_info;
    private String showing_date;
    private String showing_day;
    private String showing_status;
    private int showing_seat_cnt;

    private String stage_id;
    private String stage_name;
    private String stage_address;
    private int stage_seat_cnt;
    private String stage_manager;
    private String stage_type;
    private String stage_tel;
}


