package com.ticketplatfotm.ticket_booking.controller;

import com.ticketplatfotm.ticket_booking.repository_entity.MovieEntity;
import com.ticketplatfotm.ticket_booking.service.MovieService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MovieController {

    private MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public String listAllMovies(Model model){
        model.addAttribute("movies", movieService.getAllMovies());
        return "movies";
    }

    @GetMapping("/movies/add")
    public String addMovies(Model model){

        MovieEntity movieEntity = new MovieEntity();
        try{
            model.addAttribute("movie", movieEntity);
        } catch (Exception e){
            e.printStackTrace();
        }
        return "add_movie";
    }

    @PostMapping("/movies/add/save")
    public String addMovie(@Valid @ModelAttribute("movie") MovieEntity movie,
                               BindingResult result,
                               Model model) {
        MovieEntity existingMovieByName = movieService.getByName(movie.getName());

        if(existingMovieByName != null && existingMovieByName.getName() != null && !existingMovieByName.getName().isEmpty()){
            result.rejectValue("name", null,
                    "There is already a movie with that name");
        }

        if(result.hasErrors()){
            model.addAttribute("movie", movie);
            return "/add_movie";
        }
        movieService.saveMovie(movie);
        return "redirect:/movies/add?success";
    }
}
