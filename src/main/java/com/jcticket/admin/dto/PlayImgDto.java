package com.jcticket.admin.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Timestamp;

/**
 * packageName :  com.jcticket.admin.dto
 * fileName : PlayImgDto
 * author :  jisoo Son
 * date : 2024-02-27
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2024-02-27             jisoo Son             최초 생성
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class PlayImgDto {
    //CREATE TABLE play_image (
    //    play_image_seq INT  NOT NULL AUTO_INCREMENT COMMENT '공연 이미지 일련번호',
    //    play_id VARCHAR(20) NOT NULL,
    //    play_poster_original_file_name VARCHAR(200) NULL COMMENT '공연 표지 원본파일(java.jpg)',
    //    play_poster_stored_file_name VARCHAR(200) NULL COMMENT '공연 표지 변경파일(java.20240227.jpg)',
    //    play_info_original_file_name VARCHAR(200) NULL COMMENT '공연 정보 원본파일(java.jpg)',
    //    play_info_stored_file_name VARCHAR(200) NULL COMMENT '공연 정보 변경파일(java.20240227.jpg)',
    //    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    //    created_id VARCHAR(36) NOT NULL,
    //    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    //    updated_id VARCHAR(36) NOT NULL,
    //    CONSTRAINT fk_play_image_play_id FOREIGN KEY (play_id) REFERENCES play (play_id) ON DELETE CASCADE,
    //    PRIMARY KEY (play_image_seq, play_id)
    //);

    private int play_image_seq ;
    private String play_id;
    private String play_poster_original_file_name ;     // 공연 표지 원본파일 (사용자가 올린 원본 파일)
    private String play_poster_stored_file_name ;       // 공연 표지 변경파일 (사진 이름의 중복 방지, 언제, 파일 이름을 구분하기 위함)
    private String play_info_original_file_name ;       // 공연 정보 원본파일
    private String play_info_stored_file_name ;         // 공연 정보 변경파일
    private String play_slide_original_file_name;            // 메인페이지 슬라이드 원본 파일
    private String play_slide_stored_file_name;              // 메인페이지 슬라이드 변경 파일
    private Timestamp created_at;
    private String created_id;
    private Timestamp updated_at;
    private String updated_id;

}