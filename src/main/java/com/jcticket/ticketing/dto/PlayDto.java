package com.jcticket.ticketing.dto;

import lombok.*;

import java.sql.Timestamp;

/**
 * packageName    : com.jcticket.ticketing.dto
 * fileName       : PlayDto
 * author         : 조영상
 * date           : 2/13/24
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2/13/24         조영상        최초 생성
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class PlayDto {
    //    `play_id` varchar(20) NOT NULL,
    //  `play_name` varchar(100) NOT NULL,
    //  `play_poster` blob NOT NULL COMMENT '이미지파일',
    //            `play_info` blob NOT NULL COMMENT '이미지파일',
    //            `play_major_cat` varchar(30) NOT NULL COMMENT '문화/  -> 공통 코드 관리',
    //            `play_middle_cat` varchar(30) NOT NULL COMMENT '문화/뮤지컬  -> 공통 코드 관리',
    //            `play_small_cat` varchar(30) NOT NULL COMMENT '문화/뮤지컬/오리지널  -> 공통 코드 관리',
    //            `play_run_time` int NOT NULL COMMENT '분 단위 런닝타임',
    //            `agency_id` varchar(30) NOT NULL,
    //  `created_at` timestamp NOT NULL,
    //            `created_id` varchar(30) NOT NULL,
    //  `updated_at` timestamp NOT NULL,
    //            `updated_id` varchar(30) NOT NULL,
    //    PRIMARY KEY (`play_id`)

    private int play_id;
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
