package com.ticketplatfotm.ticket_booking.repository_entity;

import jakarta.persistence.*;

@Entity
@Table(name = "halls")
@SequenceGenerator(name="hall_seq",sequenceName="mv_hall_seq", allocationSize = 1)
public class HallEntity {

    @Id
    @Column(name = "hall_id")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="hall_seq")
    private Long hallId;
    @Column(name = "cinema_id")
    private Long cinemaId;
    @Column(name = "hall_colour")
    private String hallColour;
    @Column(name = "number_of_seats")
    private Integer numberOfSeats;

    public HallEntity() {
    }

    public HallEntity(Long hallId, Long cinemaId, String hallColour, Integer numberOfSeats) {
        this.hallId = hallId;
        this.cinemaId = cinemaId;
        this.hallColour = hallColour;
        this.numberOfSeats = numberOfSeats;
    }

    public Long getHallId() {
        return hallId;
    }

    public void setHallId(Long hallId) {
        this.hallId = hallId;
    }

    public Long getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(Long cinemaId) {
        this.cinemaId = cinemaId;
    }

    public String getHallColour() {
        return hallColour;
    }

    public void setHallColour(String hallColour) {
        this.hallColour = hallColour;
    }

    public Integer getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(Integer numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }
}
