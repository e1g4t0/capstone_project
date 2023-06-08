package com.ticketplatfotm.ticket_booking.repository;

import com.ticketplatfotm.ticket_booking.repository_entity.SeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeatsEntityRepository extends JpaRepository<SeatEntity, Long> {
    List<SeatEntity> findByHallIdAndIsBookedFalse(Long id);

}
