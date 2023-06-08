package com.ticketplatfotm.ticket_booking.repository_entity;

import jakarta.persistence.*;

@Entity
@Table(name = "movie_actor")
@SequenceGenerator(name="ma_seq",sequenceName="mv_movieactor_seq", allocationSize = 1)
public class MovieActorEntity {

    @Id
    @Column(name = "movie_actor_id")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ma_seq")
    private Long movieActorId;
    @Column(name = "movie_id")
    private Long movieId;
    @Column(name = "actor_id")
    private Long actorId;

    public MovieActorEntity() {
    }

    public MovieActorEntity(Long movieActorId, Long movieId, Long actorId) {
        this.movieActorId = movieActorId;
        this.movieId = movieId;
        this.actorId = actorId;
    }
}
