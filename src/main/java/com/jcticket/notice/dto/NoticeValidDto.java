package com.jcticket.notice.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;

/**
 * packageName :  com.jcticket.admin.dto
 * fileName : NoticeValidDto
 * author :  jisoo Son
 * date : 2024-02-19
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2024-02-19             jisoo Son             최초 생성
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class NoticeValidDto {
    @NotBlank(message = "제목은 필수 입력 값입니다.")
    private String notice_title;
    @NotBlank(message = "내용은 필수 입력 값입니다.")
    private String notice_content;
    private String admin_id;
    private int notice_seq;
}