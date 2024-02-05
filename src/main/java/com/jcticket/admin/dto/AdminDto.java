package com.jcticket.admin.dto;

import lombok.*;

import java.sql.Timestamp;

/**
 * packageName :  com.jcticket.admin.dto
 * fileName : AdminDto
 * author :  jisoo Son
 * date : 2024-02-05
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2024-02-05             jisoo Son             최초 생성
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class AdminDto {

//    CREATE TABLE `admin` (
//        `admin_id` varchar(20) NOT NULL,
//        `admin_email` varchar(20) NOT NULL,
//        `admin_password` varchar(16) NOT NULL,
//        `admin_phone` varchar(20) NOT NULL,
//        `admin_nickname` varchar(30) DEFAULT NULL,
//        `admin_use_yn` char(1) NOT NULL DEFAULT 'Y' COMMENT '사용하지 않을 시에 N 으로 수정',
//        `admin_reg_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '등록시 현재일자',
//        `admin_auth` varchar(10) DEFAULT NULL COMMENT '공통코드 관리 회원 U, 기획사 A, 최종 S',
//        `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
//        `created_id` varchar(36) NOT NULL,
//        `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
//        `updated_id` varchar(36) NOT NULL,
//        PRIMARY KEY (`admin_id`)
//    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

    private String admin_id;
    private String admin_email;
    private String admin_password;
    private String admin_phone;
    private String admin_nickname;
    private String admin_use_yn;
    private Timestamp admin_reg_at;
    private String admin_auth;
    private Timestamp created_at;
    private String created_id;
    private Timestamp updated_at;
    private String updated_id;

    public AdminDto(String admin_id, String admin_password){
        this.admin_id = admin_id;
        this.admin_password = admin_password;
    }
}