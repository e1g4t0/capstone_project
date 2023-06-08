package com.ticketplatfotm.ticket_booking.service;

import com.ticketplatfotm.ticket_booking.repository_entity.HallEntity;
import com.ticketplatfotm.ticket_booking.repository.HallsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HallsService {

    @Autowired
    private HallsRepository hallsRepository;

    public HallsService() {
    }

    public HallsService(HallsRepository hallsRepository) {
        this.hallsRepository = hallsRepository;
    }

    public List<HallEntity> getAllHalls(){

        return hallsRepository.findAll();
    }

    public HallEntity getById(Long id){
        return hallsRepository.findById(id).get();
    }

    public HallEntity findByHallColour(String colour){

        return hallsRepository.findByHallColour(colour);
    }


}
