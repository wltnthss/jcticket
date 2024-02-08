package com.jcticket.agency.dto;

import lombok.*;

import java.sql.Timestamp;

/**
 * packageName    : com.jcticket.agency.dto
 * fileName       : AgencyDto
 * author         : {sana}
 * date           : 2024-02-05
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-05        {sana}       최초 생성
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class AgencyDto {

//1. DTO 생성 : 데이터베이스의 테이블 구조와 일치하도록 DTO 생성 한다.  각 필드는 private을 써서 getter,  setter 메서드 어.. 사용?
//    CREATE TABLE `Agency` (
//            `agency_id`	VARCHAR(30)	NOT NULL,
//	`agency_password`	INT	NOT NULL,
//            `agency_name`	VARCHAR(30)	NOT NULL,
//	`agency_email`	VARCHAR(30)	NOT NULL,
//	`agency_tel`	INT	NOT NULL,
//            `agency_register_num`	INT	NOT NULL,
//            `agency_reg_at`	TIMESTAMP	NOT NULL	DEFAULT current_timestamp,
//            `agency_status_val`	VARCHAR(10)	NOT NULL	COMMENT '운영중, 폐업, 계약만료',
//            `agency_contract_reg_at`	TIMESTAMP	NOT NULL,
//            `agency_contract_expire_at`	TIMESTamP	NOT NULL,
//            `agency_content`	TEXT	NULL,
//	`agency_manager_name`	VARCHAR(10)	NOT NULL,
//	`created_at`	TIMESTAMP	NOT NULL DEFAULT current_timestamp,
//            `created_id`	VARCHAR(30)	NOT NULL,
//	   `updated_at`	TIMESTAMP	NOT NULL DEFAULT current_timestamp,
//            `updated_id`	VARCHAR(30)	NOT NULL
//);

    private String agency_id;
    private String agency_password;
    private String agency_name;
    private String agency_email;
    private String agency_tel;
    private String agency_register_num;
    private Timestamp agency_reg_at;
    private String agency_status_val;
    private Timestamp agency_contract_reg_at;
    private Timestamp agency_contract_expire_at;
    private String agency_content;
    private String agency_manager_name;
    private String created_at;
    private String created_id;
    private String updated_at;
    private String updated_id;

    public AgencyDto(String agency_id, String agency_password){
        this.agency_id = agency_id;
        this.agency_password = agency_password;
    }
}
