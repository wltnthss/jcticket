package com.jcticket.user.dto;

import lombok.*;

import java.sql.Timestamp;

/**
 * packageName    : com.jcticket.signup.dto
 * fileName       : termsDto
 * author         : jinwook Song
 * date           : 2024-02-11
 * description    : 약관Dto
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-11        jinwook Song       최초 생성
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class TermsDto {
    private int user_terms_seq;
    private int terms_seq;
    private String user_id;
    private String agreement;
    private Timestamp agreement_at;
    private Timestamp created_at;
    private String created_id;
    private Timestamp updated_at;
    private String updated_id;

    public TermsDto(int terms_seq, String user_id, String agreement, Timestamp agreement_at, Timestamp created_at, String created_id, Timestamp updated_at, String updated_id) {
        this.terms_seq = terms_seq;
        this.user_id = user_id;
        this.agreement = agreement;
        this.agreement_at = agreement_at;
        this.created_at = created_at;
        this.created_id = created_id;
        this.updated_at = updated_at;
        this.updated_id = updated_id;
    }




}
