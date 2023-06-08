package com.ticketplatfotm.ticket_booking.repository_entity;

import jakarta.persistence.*;

@Entity
@Table(name = "seats")
@SequenceGenerator(name="seat_seq",sequenceName="mv_seat_seq", allocationSize = 1)
public class SeatEntity {

    @Id
    @Column(name = "seat_id")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seat_seq")
    private Long seatId;
    @Column(name = "seat_number")
    private Integer seatNumber;
    @Column(name = "seat_type")
    private String seatType;
    @Column(name = "hall_id")
    private Long hallId;
    @Column(name = "is_booked")
    private Boolean isBooked;

    public SeatEntity() {
    }

    public SeatEntity(Long seatId, Integer seatNumber, String seatType, Long hallId, Boolean isBooked) {
        this.seatId = seatId;
        this.seatNumber = seatNumber;
        this.seatType = seatType;
        this.hallId = hallId;
        this.isBooked = isBooked;
    }

    public Long getSeatId() {
        return seatId;
    }

    public void setSeatId(Long seatId) {
        this.seatId = seatId;
    }

    public Integer getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(Integer seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    public Long getHallId() {
        return hallId;
    }

    public void setHallId(Long hallId) {
        this.hallId = hallId;
    }

    public Boolean getBooked() {
        return isBooked;
    }

    public void setBooked(Boolean booked) {
        isBooked = booked;
    }

    @Override
    public String toString() {
        return "SeatsEntity{" +
                "seatId=" + seatId +
                ", seatNumber=" + seatNumber +
                ", seatType='" + seatType + '\'' +
                ", hallId=" + hallId +
                ", isBooked=" + isBooked +
                '}';
    }
}
