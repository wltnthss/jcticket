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
    private Timestamp user_retire_at;
    private String user_retire_yn;
    private int user_visit_cnt;
    private String user_interested_genre;
    private String user_rmark;
    private Timestamp created_at;
    private String created_id;
    private Timestamp updated_at;
    private String updated_id;
    
    public UserDto(String user_id, String user_password){
        this.user_id = user_id;
        this.user_password = user_password;
    }

    public UserDto(String user_id, String user_password, String user_name, String user_email, String user_tel, String user_address, String user_nickname, String user_birth, String user_gender, Timestamp user_create_at, String user_retire_yn, int user_visit_cnt, String user_interested_genre, Timestamp created_at, String created_id, Timestamp updated_at, String updated_id) {
        this.user_id = user_id;
        this.user_password = user_password;
        this.user_name = user_name;
        this.user_email = user_email;
        this.user_tel = user_tel;
        this.user_address = user_address;
        this.user_nickname = user_nickname;
        this.user_birth = user_birth;
        this.user_gender = user_gender;
        this.user_create_at = user_create_at;
        this.user_retire_yn = user_retire_yn;
        this.user_visit_cnt = user_visit_cnt;
        this.user_interested_genre = user_interested_genre;
        this.created_at = created_at;
        this.created_id = created_id;
        this.updated_at = updated_at;
        this.updated_id = updated_id;
    }


}
