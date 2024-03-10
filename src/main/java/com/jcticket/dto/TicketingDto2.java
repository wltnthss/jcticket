package com.jcticket.dto;

import lombok.*;

import java.sql.Timestamp;

/**
 * packageName    : com.jcticket.dto
 * fileName       : TicketingDto2
 * author         : 조영상
 * date           : 3/10/24
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 3/10/24         조영상        최초 생성
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@ToString
@EqualsAndHashCode
public class TicketingDto2 {
    private String ticketing_id;
    private Timestamp ticketing_at;//default current_timestamp
    private int ticketing_cnt; // 예매 수량
    private String ticketing_status; // 예매 상태 default 'Y'
    private String play_name;
    private String stage_name;
    private String showing_info; //회차정보
    private String showing_date; //공연 날짜
    private String selected_seats; //좌석선택목록
    private int ticketing_price; // 예매가격
    private String user_id;
    private String user_name;
    private Timestamp cancelable_at; //취소 가능일시
    private Timestamp created_at; //default current_timestamp
    private String created_id;
    private Timestamp updated_at;//default current_timestamp
    private String updated_id;
}
