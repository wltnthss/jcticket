package com.jcticket.mypage.dto;

import lombok.*;

import java.sql.Timestamp;

/**
 * packageName    : com.jcticket.mypage.dto
 * fileName       : InquiryDto
 * author         : JJS
 * date           : 2024-02-20
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-20        JJS       최초 생성
 */

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class InquiryDto {
    private Integer inquiry_seq;
    private String inquiry_title;
	private String inquiry_img;
    private String inquiry_content;
    private Timestamp inquiry_time;
    private String inquiry_category;
    private String user_id;
    private Timestamp created_at;
    private String created_id;
    private Timestamp updated_at;
    private String updated_id;
}
