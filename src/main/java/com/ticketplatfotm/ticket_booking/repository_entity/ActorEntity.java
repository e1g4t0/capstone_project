package com.ticketplatfotm.ticket_booking.repository_entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "actors")
public class ActorEntity {
    @Id
    @Column(name = "actor_id")
    private Long actorId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "birth_date")
    private LocalDate birthDate;
    @Column(name = "rating")
    private float rating;
    @Column(name = "country")
    private String country;

    public ActorEntity() {
    }

    public ActorEntity(Long actorId, String firstName, String lastName, LocalDate birthDate, float rating, String country) {
        this.actorId = actorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.rating = rating;
        this.country = country;
    }

    @Override
    public String toString() {
        return "ActorsEntity{" +
                "actorId=" + actorId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", rating=" + rating +
                ", country='" + country + '\'' +
                '}';
    }
}
