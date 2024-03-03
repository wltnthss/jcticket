package com.jcticket.dto;

import lombok.*;

import java.sql.Timestamp;

/**
 * packageName    : com.jcticket.dto
 * fileName       : SeatDto
 * author         : 조영상
 * date           : 2/26/24
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2/26/24         조영상        최초 생성
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class SeatDto {
    private String seat_row;
    private int seat_col;
    private String stage_id;
    private Timestamp created_at;
    private String created_id;
    private Timestamp updated_at;
    private String updated_id;

    public SeatDto(String seat_row, int seat_col, String stage_id){
        this.seat_row = seat_row;
        this.seat_col = seat_col;
        this.stage_id = stage_id;
    }
}
