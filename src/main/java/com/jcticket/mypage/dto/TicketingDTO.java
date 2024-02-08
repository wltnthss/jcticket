package com.jcticket.mypage.dto;

import java.sql.Timestamp;
import java.util.Objects;

/**
 * packageName    : com.jcticket.mypage.dto
 * fileName       : TicketingDTO
 * author         : JJS
 * date           : 2024-02-08
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-08        JJS       최초 생성
 */
public class TicketingDTO {
    private String ticketingId;
    private Timestamp ticketingAt;
    private int ticketingCnt;
    private String ticketingStatus;
    private String showingInfo;
    private String showingDate;
    private Timestamp cancelableAt;
    private Integer playPrice;
    private String stageName;
    private String choiceShowSeat;
    private int ticketingPrice;
    private String userName;
    private Timestamp viewingAt;
    private String playName;
    private Timestamp createdAt;
    private String createdId;
    private Timestamp updatedAt;
    private String updatedId;

    public String getTicketingId() {
        return ticketingId;
    }

    public void setTicketingId(String ticketingId) {
        this.ticketingId = ticketingId;
    }

    public Timestamp getTicketingAt() {
        return ticketingAt;
    }

    public void setTicketingAt(Timestamp ticketingAt) {
        this.ticketingAt = ticketingAt;
    }

    public int getTicketingCnt() {
        return ticketingCnt;
    }

    public void setTicketingCnt(int ticketingCnt) {
        this.ticketingCnt = ticketingCnt;
    }

    public String getTicketingStatus() {
        return ticketingStatus;
    }

    public void setTicketingStatus(String ticketingStatus) {
        this.ticketingStatus = ticketingStatus;
    }

    public String getShowingInfo() {
        return showingInfo;
    }

    public void setShowingInfo(String showingInfo) {
        this.showingInfo = showingInfo;
    }

    public String getShowingDate() {
        return showingDate;
    }

    public void setShowingDate(String showingDate) {
        this.showingDate = showingDate;
    }

    public Timestamp getCancelableAt() {
        return cancelableAt;
    }

    public void setCancelableAt(Timestamp cancelableAt) {
        this.cancelableAt = cancelableAt;
    }

    public Integer getPlayPrice() {
        return playPrice;
    }

    public void setPlayPrice(Integer playPrice) {
        this.playPrice = playPrice;
    }

    public String getStageName() {
        return stageName;
    }

    public void setStageName(String stageName) {
        this.stageName = stageName;
    }

    public String getChoiceShowSeat() {
        return choiceShowSeat;
    }

    public void setChoiceShowSeat(String choiceShowSeat) {
        this.choiceShowSeat = choiceShowSeat;
    }

    public int getTicketingPrice() {
        return ticketingPrice;
    }

    public void setTicketingPrice(int ticketingPrice) {
        this.ticketingPrice = ticketingPrice;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Timestamp getViewingAt() {
        return viewingAt;
    }

    public void setViewingAt(Timestamp viewingAt) {
        this.viewingAt = viewingAt;
    }

    public String getPlayName() {
        return playName;
    }

    public void setPlayName(String playName) {
        this.playName = playName;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedId() {
        return createdId;
    }

    public void setCreatedId(String createdId) {
        this.createdId = createdId;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdatedId() {
        return updatedId;
    }

    public void setUpdatedId(String updatedId) {
        this.updatedId = updatedId;
    }

    public TicketingDTO(String ticketingId, Timestamp ticketingAt, int ticketingCnt, String ticketingStatus, Timestamp viewingAt, String playName) {
        this.ticketingId = ticketingId;
        this.ticketingAt = ticketingAt;
        this.ticketingCnt = ticketingCnt;
        this.ticketingStatus = ticketingStatus;
        this.viewingAt = viewingAt;
        this.playName = playName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketingDTO that = (TicketingDTO) o;
        return ticketingCnt == that.ticketingCnt && Objects.equals(ticketingId, that.ticketingId) && Objects.equals(ticketingAt, that.ticketingAt) && Objects.equals(ticketingStatus, that.ticketingStatus) && Objects.equals(viewingAt, that.viewingAt) && Objects.equals(playName, that.playName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticketingId, ticketingAt, ticketingCnt, ticketingStatus, viewingAt, playName);
    }

    public TicketingDTO() {
    }
}
