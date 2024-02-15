package com.jcticket.agency.dto;

import lombok.*;

/**
 * packageName    : com.jcticket.agency.dto
 * fileName       : EnrollDto
 * author         : {sana}
 * date           : 2024-02-14
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-14        {sana}       최초 생성
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class EnrollDto {
    private String agencyName;
    private String playName;
    private String showingName;
    private String stageName;

   //새 Dto 생성 후 값 전부 받아오기
}
