package com.jcticket.agency.dto;

import lombok.*;

import java.sql.Timestamp;
/**
 * packageName    : com.jcticket.agency.dto
 * fileName       : PlayDto
 * author         : {sana}
 * date           : 2024-02-13
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-13        {sana}       최초 생성
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class PlayDto {
//    CREATE TABLE `play` (
//            `play_id`	VARCHAR(20)	NOT NULL,
//	          `play_name`	VARCHAR(100)	NOT NULL,
//	          `play_poster`	BLOB	NOT NULL	COMMENT '이미지파일',
//            `play_info`	BLOB	NOT NULL	COMMENT '이미지파일',
//            `play_major_cat`	VARCHAR(30)	NOT NULL	COMMENT '문화/  -> 공통 코드 관리',
//            `play_middle_cat`	VARCHAR(30)	NOT NULL	COMMENT '문화/뮤지컬  -> 공통 코드 관리',
//            `play_small_cat`	VARCHAR(30)	NOT NULL	COMMENT '문화/뮤지컬/오리지널  -> 공통 코드 관리',
//            `play_run_time`	INT	NOT NULL	COMMENT '분 단위 런닝타임',
//            `agency_id`	VARCHAR(30)	NOT NULL,
//	          `created_at`	TIMESTAMP	NOT NULL	DEFAULT current_timestamp,
//            `created_id`	VARCHAR(36)	NOT NULL,
//	          `updated_at`	TIMESTAMP	NOT NULL	DEFAULT current_timestamp,
//            `updated_id`	VARCHAR(36)	NOT NULL
//);
//
//    ALTER TABLE `play` ADD CONSTRAINT `PK_PLAY` PRIMARY KEY (
//	`play_id`
//    );

    private String playId;
    private String playName;
    private byte[] playPoster;
    private byte[] playInfo;
    private String playMajorCat;
    private String playMiddleCat;
    private String playSmallCat;
    private int playRunTime;
    private String agencyId;
    private Timestamp createdAt;
    private String createdId;
    private Timestamp updatedAt;
    private String updatedId;

}
