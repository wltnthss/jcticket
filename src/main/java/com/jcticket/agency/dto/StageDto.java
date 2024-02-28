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
    private String stage_id;
    private String stage_name;
    private String stage_address;
    private int stage_seat_cnt;
    private String stage_manager;
//    private String stage_type; 삭제
    private String stage_tel;
    private Timestamp created_at;
    private String created_id;
    private Timestamp updated_at;
    private String updated_id;
}





