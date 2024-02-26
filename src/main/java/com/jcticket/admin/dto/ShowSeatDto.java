package com.jcticket.admin.dto;

import lombok.*;

import java.sql.Timestamp;

/**
 * packageName :  com.jcticket.admin.dto
 * fileName : ShowSeatDto
 * author :  jisoo Son
 * date : 2024-02-26
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2024-02-26             jisoo Son             최초 생성
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class ShowSeatDto {
    //    CREATE TABLE `show_seat` (
//            `showing_seq`	INT	NOT NULL,
//            `seat_row`	VARCHAR(10)	NOT NULL,
//	        `seat_col`	INT	NOT NULL,
//            `stage_id`	VARCHAR(30)	NOT NULL,
//	        `show_seat_status`	CHAR(1)	NOT NULL	DEFAULT 'Y'	COMMENT '예약시 N 업데이트',
//            `created_at`	TIMESTAMP	NOT NULL,
//            `created_id`	VARCHAR(36) NOT NULL,
//	        `updated_at`	TIMESTAMP	NOT NULL,
//            `updated_id`	VARCHAR(36)NOT NULL
//    );
    private int showing_seq;
    private String seat_row;
    private int seat_col;
    private String stage_id;
    private String show_seat_status;
    private Timestamp created_at;
    private String created_id;
    private Timestamp updated_at;
    private String updated_id;
}