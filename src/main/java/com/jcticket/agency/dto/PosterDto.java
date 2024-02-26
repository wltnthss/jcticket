package com.jcticket.agency.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * packageName    : com.jcticket.agency.dto
 * fileName       : PosterDto
 * author         : {sana}
 * date           : 2024-02-26
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-26        {sana}       최초 생성
 */
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class PosterDto {
    private MultipartFile play_poster_file;
    private MultipartFile play_info_file;

}
