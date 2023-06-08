package com.ticketplatfotm.ticket_booking.repository_entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "movie_schedule")
@SequenceGenerator(name="sch_seq",sequenceName="mv_schedule_seq", allocationSize = 1)
public class MovieScheduleEntity {

    @Id
    @Column(name = "schedule_id")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sch_seq")
    private Long scheduleId;
    @Column(name = "movie_id")
    private Long movieId;
    @Column(name = "hall_id")
    private Long hallId;
    @Column(name = "movie_date")
    private LocalDate movieDate;
    @Column(name = "movie_time")
    private LocalTime movieTime;
    @Column(name = "price")
    private Integer price;

    public MovieScheduleEntity() {
    }

    public MovieScheduleEntity(Long scheduleId, Long movieId, Long hallId, LocalDate movieDate, LocalTime movieTime, Integer price) {
        this.scheduleId = scheduleId;
        this.movieId = movieId;
        this.hallId = hallId;
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

    public Long getHallId() {
        return hallId;
    }

    public void setHallId(Long hallId) {
        this.hallId = hallId;
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
}
