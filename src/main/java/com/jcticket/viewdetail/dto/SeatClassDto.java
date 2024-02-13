package com.jcticket.viewdetail.dto;

import lombok.*;

import java.security.Timestamp;

/**
 * packageName    : com.jcticket.viewdetail.dto
 * fileName       : SeatClassDto
 * author         : sungjun
 * date           : 2024-02-08
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-08        kyd54       최초 생성
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class SeatClassDto {
    private int seatGradeSeq;
    private int seatPrice;
    private String showId;
    private Timestamp createdAt;
    private String createdId;
    private Timestamp updatedAt;
    private String updateId;

}
