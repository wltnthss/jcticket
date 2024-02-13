package com.jcticket.agency.dto;

import lombok.*;

import java.sql.Timestamp;
/**
 * packageName    : com.jcticket.agency.dto
 * fileName       : StageDto
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
public class StageDto {
//    CREATE TABLE `Stage` (
//              `stage_id`	VARCHAR(30)	NOT NULL,
//	            `stage_name`	VARCHAR(50)	NOT NULL,
//	            `stage_address`	VARCHAR(300)	NOT NULL,
//	            `stage_seat_cnt`	INT	NOT NULL,
//              `stage_manager`	VARCHAR(20)	NOT NULL,
//	            `stage_type`	CHAR(1)	NOT NULL	COMMENT 'A 면 지정석 N 이면  비지정석',
//              `stage_tel`	VARCHAR(20)	NOT NULL,
//	            `created_at`	TIMESTAMP	NOT NULL	DEFAULT current_timestamp,
//              `created_id`	VARCHAR(36)	NOT NULL,
//	            `updated_at`	TIMESTAMP	NOT NULL	DEFAULT current_timestamp,
//              `updated_id`	VARCHAR(36)	NOT NULL
//);
//
//    ALTER TABLE `Stage` ADD CONSTRAINT `PK_STAGE` PRIMARY KEY (
//	`stage_id`
//    );

    private String stageId;
    private String stageName;
    private String stageAddress;
    private int stageSeatCnt;
    private String stageManager;
    private char stageType;
    private String stageTel;
    private Timestamp createdAt;
    private String createdId;
    private Timestamp updatedAt;
    private String updatedId;
}
