package com.jcticket.viewdetail.dto;

import lombok.*;

import java.sql.Timestamp;

/**
 * packageName    : com.jcticket.viewdetail.dto
 * fileName       : ReviewDto
 * author         : sungjun
 * date           : 2024-02-17
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-17        kyd54       최초 생성
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class ReviewDto {
    private int review_num;
    private Timestamp review_at;
    private int review_star_rating;
    private String review_viewing_at;
    private String review_content;
//    private double review_star_rating_avg;
    private int review_total;
    private String user_id;
    private String play_id;
    private Timestamp created_at;
    private String created_id;
    private Timestamp updated_at;
    private String updated_id;
    private double review_avg;
    private int review_count;
}
