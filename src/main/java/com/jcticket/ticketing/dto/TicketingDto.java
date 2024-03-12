package com.jcticket.ticketing.dto;

import lombok.*;

import java.sql.Timestamp;
import java.util.Date;

/**
 * packageName    : com.jcticket.ticketing.dto
 * fileName       : TicketDto
 * author         : 조영상
 * date           : 1/31/24
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 1/31/24         조영상        최초 생성
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TicketingDto {
    private String ticketing_id; // 예매번호
    private Timestamp ticketing_at; //예매 날짜
    private int ticketing_cnt; // 예매 수량
    private String ticketing_status; // 예매 상태
    private String showing_info; //공연정보
    private String showing_date; //공연 날짜
    private Timestamp cancelable_at; //취소 날짜
    private int play_price; //가격
    private String stage_name; //
    private String choice_show_seat;
    private String selected_seats;

    public String getSelected_seats() {
        return selected_seats;
    }

    public void setSelected_seats(String selected_seats) {
        this.selected_seats = selected_seats;
    }

    public String getPlay_major_cat() {
        return play_major_cat;
    }

    public void setPlay_major_cat(String play_major_cat) {
        this.play_major_cat = play_major_cat;
    }

    private int ticketing_price;
    private String user_name;
    private String user_id;
    private Timestamp viewing_at; //TimeStamp로 바꿔야하나??
    private String play_name;
    private Timestamp created_at;
    private String created_id;
    private Timestamp updated_at;
    private String updated_id;
    private String play_major_cat;


    public String getTicketing_id() {
        return ticketing_id;
    }

    public void setTicketing_id(String ticketing_id) {
        this.ticketing_id = ticketing_id;
    }

    public Timestamp getTicketing_at() {
        return ticketing_at;
    }

    public void setTicketing_at(Timestamp ticketing_at) {
        this.ticketing_at = ticketing_at;
    }

    public int getTicketing_cnt() {
        return ticketing_cnt;
    }

    public void setTicketing_cnt(int ticketing_cnt) {
        this.ticketing_cnt = ticketing_cnt;
    }

    public String getTicketing_status() {
        return ticketing_status;
    }

    public void setTicketing_status(String ticketing_status) {
        this.ticketing_status = ticketing_status;
    }

    public String getShowing_info() {
        return showing_info;
    }

    public void setShowing_info(String showing_info) {
        this.showing_info = showing_info;
    }

    public String getShowing_date() {
        return showing_date;
    }

    public void setShowing_date(String showing_date) {
        this.showing_date = showing_date;
    }

    public Timestamp getCancelable_at() {
        return cancelable_at;
    }

    public void setCancelable_at(Timestamp cancelable_at) {
        this.cancelable_at = cancelable_at;
    }

    public int getPlay_price() {
        return play_price;
    }

    public void setPlay_price(int play_price) {
        this.play_price = play_price;
    }

    public String getStage_name() {
        return stage_name;
    }

    public void setStage_name(String stage_name) {
        this.stage_name = stage_name;
    }

    public String getChoice_show_seat() {
        return choice_show_seat;
    }

    public void setChoice_show_seat(String choice_show_seat) {
        this.choice_show_seat = choice_show_seat;
    }

    public int getTicketing_price() {
        return ticketing_price;
    }

    public void setTicketing_price(int ticketing_price) {
        this.ticketing_price = ticketing_price;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public Timestamp getViewing_at() {
        return viewing_at;
    }

    public void setViewing_at(Timestamp viewing_at) {
        this.viewing_at = viewing_at;
    }

    public String getPlay_name() {
        return play_name;
    }

    public void setPlay_name(String play_name) {
        this.play_name = play_name;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public String getCreated_id() {
        return created_id;
    }

    public void setCreated_id(String created_id) {
        this.created_id = created_id;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }

    public String getUpdated_id() {
        return updated_id;
    }

    public void setUpdated_id(String updated_id) {
        this.updated_id = updated_id;
    }

    public String getPlay_play_major_cat() {
        return play_major_cat;
    }

    public void setPlay_play_major_cat(String play_middle_cat) {
        this.play_major_cat = play_middle_cat;
    }

    public TicketingDto(String ticketing_id, Timestamp ticketing_at, int ticketing_cnt, String ticketing_status,
                        String showing_info, String showing_date, Timestamp cancelable_at, int play_price, String stage_name,
                        String choice_show_seat, int ticketing_price, String user_name, String user_id, Timestamp viewing_at, String play_name,
                        Timestamp created_at, String created_id, Timestamp updated_at, String updated_id) {

        this.ticketing_id = ticketing_id;
        this.ticketing_at = ticketing_at;
        this.ticketing_cnt = ticketing_cnt;
        this.ticketing_status = ticketing_status;
        this.showing_info = showing_info;
        this.showing_date = showing_date;
        this.cancelable_at = cancelable_at;
        this.play_price = play_price;
        this.stage_name = stage_name;
        this.choice_show_seat = choice_show_seat;
        this.ticketing_price = ticketing_price;
        this.user_name = user_name;
        this.user_id = user_id;
        this.viewing_at = viewing_at;
        this.play_name = play_name;
        this.created_at = created_at;
        this.created_id = created_id;
        this.updated_at = updated_at;
        this.updated_id = updated_id;
    }



}


