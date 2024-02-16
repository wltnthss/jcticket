package com.jcticket.agency.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.sql.Timestamp;

/**
 * packageName    : com.jcticket.agency.dto
 * fileName       : AgencyDto
 * author         : {sana}
 * date           : 2024-02-05
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-05        {sana}       최초 생성
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class AgencyDto {
    @NotBlank(message = "아이디는 필수 입력 값입니다.")
    private String agency_id;
    @NotBlank(message = "비밀번호는 필수 입력 값입니다.")
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,16}", message = "비밀번호는 8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.")
    private String agency_password;
    @NotBlank(message = "이름은 필수 입력 값입니다.")
    private String agency_name;
    @NotBlank(message = "이메일은 필수 입력 값입니다.")
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,6}$", message = "이메일 형식이 올바르지 않습니다.")
    private String agency_email;
    @NotBlank(message = "휴대폰번호는 필수 입력 값입니다.")
    @Pattern(regexp = "(010|016|011)-[0-9]{3,4}-[0-9]{4}", message = "휴대폰번호 형식이 올바르지 않습니다.")
    private String agency_tel;
    @NotBlank(message = "사업자등록번호는 필수 입력 값입니다.")
    @Pattern(regexp = "^\\d{3}-\\d{2}-\\d{5}$", message = "사업자등록번호 형식이 올바르지 않습니다.")
    private String agency_register_num;
    private Timestamp agency_reg_at;
    private String agency_status_val;
    private Timestamp agency_contract_reg_at;
    private Timestamp agency_contract_expire_at;
    private String agency_content;
    @NotBlank(message = "담당자명은 필수 입력 값입니다.")
    private String agency_manager_name;
    private Timestamp created_at;
    private String created_id;
    private Timestamp updated_at;
    private String updated_id;

    public AgencyDto(String agency_id, String agency_password){
        this.agency_id = agency_id;
        this.agency_password = agency_password;
    }
}
