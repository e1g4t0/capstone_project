package com.ticketplatfotm.ticket_booking.service;

import com.ticketplatfotm.ticket_booking.repository_entity.TicketEntity;
import com.ticketplatfotm.ticket_booking.repository.TicketsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketsService {
    @Autowired
    private TicketsRepository ticketsRepository;

    public TicketsService() {
    }

    public TicketsService(TicketsRepository ticketsRepository) {
        this.ticketsRepository = ticketsRepository;
    }

    public void save(TicketEntity ticketEntity){
        ticketsRepository.save(ticketEntity);
    }

    public List<TicketEntity> getById(Long id){

        return ticketsRepository.findByUserId(id);
    }
}
