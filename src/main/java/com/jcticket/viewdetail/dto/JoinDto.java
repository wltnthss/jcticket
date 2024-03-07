package com.jcticket.viewdetail.dto;

import lombok.*;

import java.sql.Timestamp;

/**
 * packageName    : com.jcticket.viewdetail.dto
 * fileName       : joinDto
 * author         : sungjun
 * date           : 2024-02-14
 * description    : showing, play,
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-14        kyd54       최초 생성
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class JoinDto {
    private String play_name;
    private String play_major_cat;
    private String play_middle_cat;
    private int play_run_time;
    private  int showing_seat_price;
    private String agency_id;
    private String stage_name;
    private String stage_address;

    //showing_seat_price(30000) >>>> seat_price(30,000) 포맷팅
    private String seat_price;

    // 포맷팅 메서드
    public void format_seat_price() {
        seat_price = String.format("%,d", showing_seat_price);
    }
}