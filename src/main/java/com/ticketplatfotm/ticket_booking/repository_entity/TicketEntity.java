package com.ticketplatfotm.ticket_booking.repository_entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tickets")
@SequenceGenerator(name="tick_seq",sequenceName="mv_ticket_seq", allocationSize = 1)

public class TicketEntity {

    @Id
    @Column(name = "ticket_id")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="tick_seq")
    private Long ticketId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "schedule_id")
    private Long scheduleId;

    @Column(name = "seat_id")
    private Long seatId;

    public TicketEntity() {
    }

    public TicketEntity(Long ticketId, Long userId, Long scheduleId, Long seatId) {
        this.ticketId = ticketId;
        this.userId = userId;
        this.scheduleId = scheduleId;
        this.seatId = seatId;
    }

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Long scheduleId) {
        this.scheduleId = scheduleId;
    }

    public Long getSeatId() {
        return seatId;
    }

    public void setSeatId(Long seatId) {
        this.seatId = seatId;
    }

    @Override
    public String toString() {
        return "TicketEntity{" +
                "ticketId=" + ticketId +
                ", userId=" + userId +
                ", scheduleId=" + scheduleId +
                ", seatId=" + seatId +
                '}';
    }
}
