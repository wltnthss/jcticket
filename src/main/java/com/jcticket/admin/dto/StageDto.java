package com.jcticket.admin.dto;

import lombok.*;

import java.sql.Timestamp;

/**
 * packageName :  com.jcticket.admin.dto
 * fileName : StageDto
 * author :  jisoo Son
 * date : 2024-02-23
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2024-02-23             jisoo Son             최초 생성
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class StageDto {
    private String stage_id;
    private String stage_name;
    private String stage_address;
    private int stage_seat_cnt;
    private String stage_manager;
    private String stage_tel;
    private Timestamp created_at;
    private String created_id;
    private Timestamp updated_at;
    private String updated_id;
}