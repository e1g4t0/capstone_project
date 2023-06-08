package com.ticketplatfotm.ticket_booking.domain;

import java.time.LocalDate;
import java.time.LocalTime;

public class MovieSchedule {
    public Integer scheduleNumber;
    private Long scheduleId;
    private Long movieId;
    private String name;
    private Long hallId;
    private String hallColour;
    private LocalDate movieDate;
    private LocalTime movieTime;
    private Integer price;
    private Integer seatNumber;

    public MovieSchedule() {
    }

    public MovieSchedule(Long scheduleId, Long movieId, String name, Long hallId,
                         String hallColour, LocalDate movieDate, LocalTime movieTime, Integer price) {
        this.scheduleId = scheduleId;
        this.movieId = movieId;
        this.name = name;
        this.hallId = hallId;
        this.hallColour = hallColour;
        this.movieDate = movieDate;
        this.movieTime = movieTime;
        this.price = price;
    }

    public Long getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Long scheduleId) {
        this.scheduleId = scheduleId;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getHallId() {
        return hallId;
    }

    public void setHallId(Long hallId) {
        this.hallId = hallId;
    }

    public String getHallColour() {
        return hallColour;
    }

    public void setHallColour(String hallColour) {
        this.hallColour = hallColour;
    }

    public LocalDate getMovieDate() {
        return movieDate;
    }

    public void setMovieDate(LocalDate movieDate) {
        this.movieDate = movieDate;
    }

    public LocalTime getMovieTime() {
        return movieTime;
    }

    public void setMovieTime(LocalTime movieTime) {
        this.movieTime = movieTime;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(Integer seatNumber) {
        this.seatNumber = seatNumber;
    }

    @Override
    public String toString() {
        return "MovieSchedule{" +
                "scheduleNumber=" + scheduleNumber +
                ", scheduleId=" + scheduleId +
                ", movieId=" + movieId +
                ", name='" + name + '\'' +
                ", hallId=" + hallId +
                ", hallColour='" + hallColour + '\'' +
                ", movieDate=" + movieDate +
                ", movieTime=" + movieTime +
                ", price=" + price +
                ", seatNumber=" + seatNumber +
                '}';
    }
}
