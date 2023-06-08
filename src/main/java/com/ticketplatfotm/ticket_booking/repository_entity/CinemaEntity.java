package com.ticketplatfotm.ticket_booking.repository_entity;

import jakarta.persistence.*;

@Entity
@Table(name = "cinemas")
@SequenceGenerator(name="cin_seq",sequenceName="mv_cinema_seq", allocationSize = 1)
public class CinemaEntity {

    @Id
    @Column(name = "cinema_id")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="cin_seq")
    private Long cinemaId;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "telephone")
    private String telephone;

    public CinemaEntity() {
    }

    public CinemaEntity(Long cinemaId, String name, String address, String telephone) {
        this.cinemaId = cinemaId;
        this.name = name;
        this.address = address;
        this.telephone = telephone;
    }
}
