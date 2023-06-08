package com.ticketplatfotm.ticket_booking.service;

import com.ticketplatfotm.ticket_booking.repository_entity.MovieScheduleEntity;
import com.ticketplatfotm.ticket_booking.repository.MovieScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieScheduleService{

    @Autowired
    private MovieScheduleRepository movieScheduleRepository;

    public MovieScheduleService() {
    }

    public MovieScheduleService(MovieScheduleRepository movieScheduleRepository) {
        this.movieScheduleRepository = movieScheduleRepository;
    }

    public List<MovieScheduleEntity> getAllMovieSchedule(){
        return movieScheduleRepository.findAll();
    }

    public MovieScheduleEntity getById(Long id){

        return movieScheduleRepository.findById(id).get();
    }

    public void saveSchedule(MovieScheduleEntity schedule){
        movieScheduleRepository.save(schedule);
    }


}
