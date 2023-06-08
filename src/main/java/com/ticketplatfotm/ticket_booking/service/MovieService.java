package com.ticketplatfotm.ticket_booking.service;

import com.ticketplatfotm.ticket_booking.repository_entity.MovieEntity;
import com.ticketplatfotm.ticket_booking.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public MovieService() {
    }

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<MovieEntity> getAllMovies(){

        return movieRepository.findAll();
    }

    public MovieEntity getByName(String name){

        return movieRepository.findByName(name);
    }

    public MovieEntity getById(Long id){

        return movieRepository.findById(id).get();
    }

    public void saveMovie(MovieEntity movie){
        movieRepository.save(movie);
    }
}
