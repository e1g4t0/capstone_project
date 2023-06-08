package com.ticketplatfotm.ticket_booking.service;

import com.ticketplatfotm.ticket_booking.repository_entity.SeatEntity;
import com.ticketplatfotm.ticket_booking.repository.SeatsEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatsService {

    @Autowired
    private SeatsEntityRepository seatsEntityRepository;

    public SeatsService() {
    }

    public SeatsService(SeatsEntityRepository seatsEntityRepository) {
        this.seatsEntityRepository = seatsEntityRepository;
    }

    public List<SeatEntity> getByHallIdAndFalse(Long id){
        return seatsEntityRepository.findByHallIdAndIsBookedFalse(id);
    }

    public SeatEntity getById(Long id){

        return seatsEntityRepository.findById(id).get();
    }

    public void updateSeat(Long id){

        SeatEntity seatEntity = seatsEntityRepository.findById(id).get();
        SeatEntity seatEntity1 = new SeatEntity(seatEntity.getSeatId(), seatEntity.getSeatNumber(), seatEntity.getSeatType(),
                seatEntity.getHallId(), !seatEntity.getBooked());
        seatsEntityRepository.save(seatEntity1);
    }

}
