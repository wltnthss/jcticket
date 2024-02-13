package com.jcticket.agency.dto;

import lombok.*;

import java.sql.Timestamp;
/**
 * packageName    : com.jcticket.agency.dto
 * fileName       : ShowingDto
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
public class ShowingDto {
//    CREATE TABLE `showing` (
//            `showing_seq`	INT	NOT NULL,
//            `showing_start_at`	TIMESTAMP	NOT NULL	DEFAULT current_timestamp,
//            `showing_end_at`	TIMESTAMP	NOT NULL	DEFAULT current_timestamp,
//            `showing_info`	VARCHAR(30)	NOT NULL	COMMENT '[1회] 17시 00분',
//            `showing_date`	VARCHAR(10)	NOT NULL	COMMENT '2024.11.25',
//            `showing_day`	VARCHAR(30)	NOT NULL	COMMENT '월,화',
//            `showing_status`	CHAR(2)	NULL	COMMENT 'BS 상연전, IS 상영중,  AS 상영종료',
//            `showing_seat_cnt`	INT	NOT NULL,
//            `play_id`	VARCHAR(20)	NOT NULL,
//	          `stage_id`	VARCHAR(30)	NOT NULL,
//	          `created_at`	TIMESTAMP	NOT NULL	DEFAULT current_timestamp,
//            `created_id`	VARCHAR(36)	NOT NULL,
//	          `updated_at`	TIMESTAMP	NOT NULL	DEFAULT current_timestamp,
//            `updated_id`	VARCHAR(36)	NOT NULL
//);
    private int showingSeq;
    private Timestamp showingStartAt;
    private Timestamp showingEndAt;
    private String showingInfo;
    private String showingDate;
    private String showingDay;
    private String showingStatus;
    private int showingSeatCnt;
    private String playId;
    private String stageId;
    private Timestamp createdAt;
    private String createdId;
    private Timestamp updatedAt;
    private String updatedId;

}
