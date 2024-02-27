package com.jcticket.admin.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Timestamp;

/**
 * packageName :  com.jcticket.admin.dto
 * fileName : PlayDto
 * author :  jisoo Son
 * date : 2024-02-27
 * description : 공연 Dto
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2024-02-27             jisoo Son             최초 생성
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class PlayDto {
//    `play_id` varchar(20) NOT NULL,
//    `play_name` varchar(100) NOT NULL,
//    `play_major_cat` varchar(30) NOT NULL
//    `play_middle_cat` varchar(30) NOT NULL
//    `play_small_cat` varchar(30) NOT NULL
//    `play_run_time` int NOT NULL COMMENT '분 단위 런닝타임',
//    `agency_id` varchar(30) NULL,
//    `created_at` timestamp NOT NULL,
//    `created_id` varchar(30) NOT NULL,
//    `updated_at` timestamp NOT NULL,
//    `updated_id` varchar(30) NOT NULL,
//    PRIMARY KEY (`play_id`)

    private String play_id;
    private String play_name;
    private MultipartFile play_poster;  // 공연 표지 이미지 파일 controller 담기 위함
    private MultipartFile play_info;    // 공연 정보 이미지 파일 controller 담기 위함
    private String play_file_yn;           // 공연 파일 첨부 여부 판별 위함
    private String play_major_cat;
    private String play_middle_cat;
    private String play_small_cat;
    private int play_run_time;
    private String agency_id;
    private Timestamp created_at;
    private String created_id;
    private Timestamp updated_at;
    private String updated_id;

    public PlayDto(String play_id, String play_name, String play_file_yn, String play_major_cat, String play_middle_cat, String play_small_cat, int play_run_time, String agency_id, Timestamp created_at, String created_id, Timestamp updated_at, String updated_id) {
        this.play_id = play_id;
        this.play_name = play_name;
        this.play_file_yn = play_file_yn;
        this.play_major_cat = play_major_cat;
        this.play_middle_cat = play_middle_cat;
        this.play_small_cat = play_small_cat;
        this.play_run_time = play_run_time;
        this.agency_id = agency_id;
        this.created_at = created_at;
        this.created_id = created_id;
        this.updated_at = updated_at;
        this.updated_id = updated_id;
    }
}