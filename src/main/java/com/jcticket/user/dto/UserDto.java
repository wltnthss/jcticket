package com.jcticket.user.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
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
    @NotBlank(message = "아이디는 필수 입력 값입니다.")
    private String user_id;
    @NotBlank(message = "비밀번호는 필수 입력 값입니다.")
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,16}", message = "비밀번호는 8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.")
    private String user_password;
    @NotBlank(message = "이름은 필수 입력 값입니다.")
    private String user_name;
    @NotBlank(message = "닉네임은 필수 입력 값입니다.")
    private String user_nickname;
    @NotBlank(message = "이메일은 필수 입력 값입니다.")
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,6}$", message = "이메일 형식이 올바르지 않습니다.")
    private String user_email;
    @NotBlank(message = "휴대폰번호는 필수 입력 값입니다.")
    @Pattern(regexp = "(010|016|011)-[0-9]{3,4}-[0-9]{4}", message = "휴대폰번호 형식이 올바르지 않습니다.")
    private String user_tel;
    @NotBlank(message = "주소는 필수 입력 값입니다.")
    private String user_address;
    @NotBlank(message = "생년월일은 필수 입력 값입니다.")
    @Pattern(regexp = "^\\d{4}\\d{2}\\d{2}$", message = "생년월일 형식이 올바르지 않습니다.")
    private String user_birth;
    @NotBlank(message = "성별은 필수 입력 값입니다.")
    @Pattern(regexp = "^[MW]$", message = "성별 형식이 올바르지 않습니다.")
    private String user_gender;
    private Timestamp user_create_at;
    private Timestamp user_update_at;
    private Timestamp user_retire_at;
    private String user_retire_yn;
    private int user_visit_cnt;
    @NotBlank(message = "관심장르는 필수 입력 값입니다.")
    private String user_interested_genre;
    private String user_rmark;
    private String user_sns_provider;
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

    public UserDto(String user_id, String user_password, String user_name, String user_email, String user_tel, String user_address, String user_nickname, String user_birth, String user_gender, Timestamp user_create_at, String user_retire_yn, int user_visit_cnt, String user_interested_genre,String user_sns_provider, Timestamp created_at, String created_id, Timestamp updated_at, String updated_id) {
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
        this.user_sns_provider = user_sns_provider;
        this.created_at = created_at;
        this.created_id = created_id;
        this.updated_at = updated_at;
        this.updated_id = updated_id;
    }


}
