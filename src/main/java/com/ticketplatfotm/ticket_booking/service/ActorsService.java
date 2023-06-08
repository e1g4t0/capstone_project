package com.ticketplatfotm.ticket_booking.service;

import com.ticketplatfotm.ticket_booking.repository_entity.ActorEntity;
import com.ticketplatfotm.ticket_booking.repository.ActorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorsService {
    @Autowired
    private ActorsRepository actorsRepository;

    public ActorsService() {
    }

    public ActorsService(ActorsRepository actorsRepository) {
        this.actorsRepository = actorsRepository;
    }

    public List<ActorEntity> findAllActors(){
        return actorsRepository.findAll();
    }
}
