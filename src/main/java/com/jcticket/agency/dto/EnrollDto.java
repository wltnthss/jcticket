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

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class EnrollDto {

    private int enroll_id; //pk
    private String enroll_status; // 접수상태, 're'로 고정
    private String stage_id;// @@@@@@@@@@@@@@@@@@@@@@공연장 이름을 적는게 자연스러운데 어떡하냐?@@@@@@@@@@@@@@@@

//  private String agency_id;//로그인한 사용자의 기획사 ID세션을 통해 서버에서 처리 되도록

    private int showing_seq;//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@회차 일련번호 어떡하지?@@@@@@@@@@@@@@@@@@@@@@@@s이거는 최대값 가져오는 쿼리를 하나 짜서 그걸로 받아오셔도
    private String showing_start_at; // 공연 시작 날자
    private String showing_end_at;
    private String showing_info; //크기 늘려주고 showing_date,showing_day전부 적음
//    private String showing_date;
//    private String showing_day;
    private String showing_status;//상영전 BS고정
    private int showing_seat_price;
    private int showing_seat_cnt;

    private String play_id; //이것도 내가 제출하는게 맞냐?
    private String play_name;
    private String play_poster;
    private String play_info;
    private String play_major_cat;
    private String play_middle_cat;
    //    private String play_small_cat;
    private int play_run_time;
    private  String agency_name;
    private  String agency_manager_name;
    private  String agency_email;
    private  String agency_tel;
    private Timestamp created_at;// 시스템에서 자동으로 설정되도록
    private String created_id;//로그인세션 이하동문
    private Timestamp updated_at;
    private String updated_id;



}


