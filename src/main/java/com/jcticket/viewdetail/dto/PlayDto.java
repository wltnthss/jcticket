package com.jcticket.viewdetail.dto;

import lombok.*;

import java.sql.Timestamp;

/**
 * packageName    : com.jcticket.viewdetail.dto
 * fileName       : PlayDto
 * author         : sungjun
 * date           : 2024-02-15
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-15        kyd54       최초 생성
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class PlayDto {
    private String play_id;
    private String play_name;
    private String play_poster;
    private String play_info;
    private String play_major_cat;
    private String play_middle_cat;
    private String play_small_cat;
    private int play_run_time;
    private String agency_id;
    private Timestamp created_at;
    private String created_id;
    private Timestamp updated_at;
    private String updated_id;
}
