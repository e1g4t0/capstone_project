package com.ticketplatfotm.ticket_booking.repository;

import com.ticketplatfotm.ticket_booking.repository_entity.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketsRepository extends JpaRepository<TicketEntity, Long> {
    List<TicketEntity> findByUserId(Long id);
}
