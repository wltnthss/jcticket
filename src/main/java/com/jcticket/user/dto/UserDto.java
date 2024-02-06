package com.jcticket.user.dto;

import lombok.*;

import java.sql.Timestamp;

/**
 * packageName    : com.jcticket.login.dto
 * fileName       : loginDto
 * author         : jinwook Song
 * date           : 2024-02-01
 * description    : 로그인 Dto
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-01        jinwook Song       최초 생성
 */


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class UserDto {
    private String user_id;
    private String user_password;
    private String user_name;
    private String user_email;
    private String user_tel;
    private String user_address;
    private String user_nickname;
    private String user_birth;
    private String user_gender;
    private Timestamp user_create_at;
    private Timestamp user_update_at;
    private String user_retire_yn;
    private int user_visit_cnt;
    private String user_interested_genre;
    private String user_rmark;
    private String created_at;
    private String created_id;
    private String updated_at;
    private String updated_id;
    
    public UserDto(String user_id, String user_password){
        this.user_id = user_id;
        this.user_password = user_password;
    }
}
