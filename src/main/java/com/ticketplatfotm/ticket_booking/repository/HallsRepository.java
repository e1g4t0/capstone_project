package com.ticketplatfotm.ticket_booking.repository;

import com.ticketplatfotm.ticket_booking.repository_entity.HallEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HallsRepository extends JpaRepository<HallEntity, Long> {
    HallEntity findByHallColour(String colour);
}
