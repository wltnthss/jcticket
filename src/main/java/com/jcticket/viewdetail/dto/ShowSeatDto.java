package com.jcticket.viewdetail.dto;

import lombok.*;

import java.sql.Timestamp;

/**
 * packageName    : com.jcticket.viewdetail.dto
 * fileName       : ShowSeatDto
 * author         : sungjun
 * date           : 2024-02-11
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-11        kyd54       최초 생성
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class ShowSeatDto {
    private int seatSeq;
    private int seatGradeSeq;
    private String stageId;
    private int showingSeq;
    private char showSeatStatus;
    private Timestamp createdAt;
    private String createdId;
    private Timestamp updatedAt;
    private String updatedId;
}
