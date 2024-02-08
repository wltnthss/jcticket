package com.jcticket.signup.dto;

import lombok.*;

import java.sql.Timestamp;

/**
 * packageName    : com.jcticket.signup.dto
 * fileName       : SignupDto
 * author         : jinwook Song
 * date           : 2024-02-07
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-07        jinwook Song       최초 생성
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class SignupDto {
    private String user_id;
    private String user_pwd;
    private String user_name;
    private String user_email;
    private String user_tel;
    private String user_address;
    private String user_nickname;
    private String user_birth;
    private String user_gender;
    private Timestamp user_create_at;
    private String user_retire_yn;
    private int user_visit_cnt;
    private String user_interested_genre;
    private Timestamp created_at;
    private String created_id;
    private Timestamp updated_at;
    private String updated_id;

    public SignupDto(String user_id, String user_pwd, String user_name, String user_email, String user_tel, String user_address, String user_nickname, String user_birth, String user_gender, String user_interested_genre) {
        this.user_id = user_id;
        this.user_pwd = user_pwd;
        this.user_name = user_name;
        this.user_email = user_email;
        this.user_tel = user_tel;
        this.user_address = user_address;
        this.user_nickname = user_nickname;
        this.user_birth = user_birth;
        this.user_gender = user_gender;
        this.user_interested_genre = user_interested_genre;
    }
}
