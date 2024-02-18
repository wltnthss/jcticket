package com.jcticket.user.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * packageName    : com.jcticket.user.dto
 * fileName       : UserValidLoginDto
 * author         : jinwook Song
 * date           : 2024-02-18
 * description    : 로그인 유효성 검사를 위한 Dto
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-18        jinwook Song       최초 생성
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class UserValidLoginDto {
    @NotBlank(message = "아이디는 필수 입력 값입니다.")
    private String user_id;
    @NotBlank(message = "비밀번호는 필수 입력 값입니다.")
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,16}", message = "비밀번호는 8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.")
    private String user_password;
}
