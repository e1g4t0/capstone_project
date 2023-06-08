package com.ticketplatfotm.ticket_booking.repository_entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "movie")
@SequenceGenerator(name="mov_seq",sequenceName="mv_movie_seq", allocationSize = 1)
public class MovieEntity {

    @Id
    @Column(name = "movie_id")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="mov_seq")
    private Long movieId;
    @NotEmpty(message = "Name can not be empty")
    @Column(name = "name")
    private String name;
    @NotNull(message = "Rating can not be empty")
    @Column(name = "rating")
    private Float rating;
    @NotNull(message = "Release year can not be empty")
    @Column(name = "release_year")
    private LocalDate releaseYear;
    @NotEmpty (message = "Country can not be empty")
    @Column(name = "country")
    private String country;
    @NotEmpty (message = "Director can not be empty")
    @Column(name = "director")
    private String director;
    @NotEmpty (message = "Description can not be empty")
    @Column(name = "description")
    private String description;

    public MovieEntity() {
    }

    public MovieEntity(Long movieId, String name, Float rating, LocalDate releaseYear, String country, String director, String description) {
        this.movieId = movieId;
        this.name = name;
        this.rating = rating;
        this.releaseYear = releaseYear;
        this.country = country;
        this.director = director;
        this.description = description;
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

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public LocalDate getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(LocalDate releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
