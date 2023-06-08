package com.ticketplatfotm.ticket_booking.repository;

import com.ticketplatfotm.ticket_booking.repository_entity.MovieScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieScheduleRepository extends JpaRepository<MovieScheduleEntity, Long> {

}
