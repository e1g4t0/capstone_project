package com.ticketplatfotm.ticket_booking.domain;

import java.time.LocalDate;
import java.time.LocalTime;

public class Ticket {

    private Integer pageNumber;
    private String movieName;
    private String hallColour;
    private LocalDate movieDate;
    private LocalTime movieTime;
    private Integer price;
    private Integer seatNumber;
    private String seatType;

    public Ticket(String movieName, String hallColour, LocalDate movieDate, LocalTime movieTime, Integer price, Integer seatNumber, String seatType) {
        this.pageNumber = 0;
        this.movieName = movieName;
        this.hallColour = hallColour;
        this.movieDate = movieDate;
        this.movieTime = movieTime;
        this.price = price;
        this.seatNumber = seatNumber;
        this.seatType = seatType;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
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

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }
}
