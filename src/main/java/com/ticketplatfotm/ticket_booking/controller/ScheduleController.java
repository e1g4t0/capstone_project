package com.ticketplatfotm.ticket_booking.controller;

import com.ticketplatfotm.ticket_booking.domain.Ticket;
import com.ticketplatfotm.ticket_booking.repository_entity.*;
import com.ticketplatfotm.ticket_booking.domain.MovieSchedule;
import com.ticketplatfotm.ticket_booking.service.*;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ScheduleController {

    private MovieService movieService;
    private MovieScheduleService movieScheduleService;
    private HallsService hallsService;
    private UsersService usersService;
    private SeatsService seatsService;
    private TicketsService ticketsService;

    public ScheduleController(MovieService movieService, MovieScheduleService movieScheduleService, HallsService hallsService,
                              UsersService usersService, SeatsService seatsService, TicketsService ticketsService) {
        this.movieService = movieService;
        this.movieScheduleService = movieScheduleService;
        this.hallsService = hallsService;
        this.usersService = usersService;
        this.seatsService = seatsService;
        this.ticketsService = ticketsService;
    }

    @GetMapping("/schedule")
    public String scheduleForm(Model model) {

        MovieSchedule movieSchedule = new MovieSchedule();
        model.addAttribute("movieSchedule", movieSchedule);
        model.addAttribute("movies", movieService.getAllMovies());
        model.addAttribute("halls", hallsService.getAllHalls());
        return "schedule";
    }

    @PostMapping("/schedule/save")
    public String addSchedule(@Valid @ModelAttribute("movie_schedule") MovieSchedule movieSchedule,
                                 BindingResult result,
                                 Model model){

        HallEntity hall = hallsService.findByHallColour(movieSchedule.getHallColour());
        MovieEntity movie = movieService.getByName(movieSchedule.getName());

        MovieScheduleEntity movieScheduleEntity = new MovieScheduleEntity();
        movieScheduleEntity.setMovieId(movie.getMovieId());
        movieScheduleEntity.setHallId(hall.getHallId());
        movieScheduleEntity.setMovieDate(movieSchedule.getMovieDate());
        movieScheduleEntity.setMovieTime(movieSchedule.getMovieTime());
        movieScheduleEntity.setPrice(movieSchedule.getPrice());

        movieScheduleService.saveSchedule(movieScheduleEntity);
        return "redirect:/schedule?success";
    }

    @GetMapping("/booking")
    public String booking(Model model){
        TicketEntity ticketEntity = new TicketEntity();

        List<MovieScheduleEntity> movieScheduleEntities = movieScheduleService.getAllMovieSchedule();
        List<MovieSchedule> movieSchedules = new ArrayList<>();
        Integer scheduleNumber = 0;
        for (MovieScheduleEntity movieScheduleEntity:
             movieScheduleEntities) {
            scheduleNumber++;
            MovieEntity movieEntity = movieService.getById(movieScheduleEntity.getMovieId());
            HallEntity hallEntity = hallsService.getById(movieScheduleEntity.getHallId());
            MovieSchedule movieSchedule = new MovieSchedule(movieScheduleEntity.getScheduleId(), movieScheduleEntity.getMovieId(),
                    movieEntity.getName(), movieScheduleEntity.getHallId(), hallEntity.getHallColour(), movieScheduleEntity.getMovieDate(),
                    movieScheduleEntity.getMovieTime(),movieScheduleEntity.getPrice());
            movieSchedule.scheduleNumber = scheduleNumber;
            movieSchedules.add(movieSchedule);
        }

        MovieSchedule movieSchedule = new MovieSchedule();
        movieSchedule.scheduleNumber = 1;
        model.addAttribute("movieSchedules", movieSchedules);
        model.addAttribute("movieScheduleForHall", movieSchedule);
        model.addAttribute("ticket", ticketEntity);

        return "booking";
    }

    @PostMapping("/booking")
    public String bookingHall(@Valid @ModelAttribute("movieScheduleForHall") MovieSchedule movieScheduleForHall,
                          BindingResult result,
                          Model model){

        MovieScheduleEntity schedule = movieScheduleService.getById(movieScheduleForHall.getScheduleId());
        List<SeatEntity> seats = new ArrayList<>();

        if(schedule.getHallId().equals(1L)){
            seats = seatsService.getByHallIdAndFalse(1L);
        } else{
            seats = seatsService.getByHallIdAndFalse(2L);
        }
        model.addAttribute("seats", seats);

        TicketEntity ticketEntity = new TicketEntity();

        List<MovieScheduleEntity> movieScheduleEntities = movieScheduleService.getAllMovieSchedule();
        List<MovieSchedule> movieSchedules = new ArrayList<>();
        Integer scheduleNumber = 0;
        for (MovieScheduleEntity movieScheduleEntity:
                movieScheduleEntities) {
            scheduleNumber++;
            MovieEntity movieEntity = movieService.getById(movieScheduleEntity.getMovieId());
            HallEntity hallEntity = hallsService.getById(movieScheduleEntity.getHallId());
            MovieSchedule movieSchedule = new MovieSchedule(movieScheduleEntity.getScheduleId(), movieScheduleEntity.getMovieId(),
                    movieEntity.getName(), movieScheduleEntity.getHallId(), hallEntity.getHallColour(), movieScheduleEntity.getMovieDate(),
                    movieScheduleEntity.getMovieTime(),movieScheduleEntity.getPrice());
            movieSchedule.scheduleNumber = scheduleNumber;
            movieSchedules.add(movieSchedule);
        }
        ticketEntity.setScheduleId(movieScheduleForHall.getScheduleId());
        model.addAttribute("movieSchedules", movieSchedules);
        model.addAttribute("movieScheduleForHall", movieScheduleForHall);
        model.addAttribute("ticket", ticketEntity);
        return "booking";
    }

    @PostMapping("/booking/save")
    public String saveTicket(@Valid @ModelAttribute("ticket") TicketEntity ticketEntity,
                             @Valid @ModelAttribute("movieScheduleForHall") MovieSchedule movieScheduleForHall,
                             BindingResult result,
                             Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserEntity userEntity = usersService.findByUsername(auth.getName());
        ticketEntity.setUserId(userEntity.getUserId());
        ticketsService.save(ticketEntity);
        seatsService.updateSeat(ticketEntity.getSeatId());
        return "redirect:/booking?success";
    }

    @GetMapping("/tickets")
    public String getTickets(Model model){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserEntity userEntity = usersService.findByUsername(auth.getName());
        List<TicketEntity> ticketsEntities = ticketsService.getById(userEntity.getUserId());
        List<MovieScheduleEntity> movieScheduleEntities = new ArrayList<>();
        List<Ticket> tickets = new ArrayList<>();

        Integer pageNumber = 0;
        for (TicketEntity ticketEntity :
                ticketsEntities) {

            MovieScheduleEntity movieScheduleEntityToTicket = movieScheduleService.getById(ticketEntity.getScheduleId());
            MovieEntity movieToTicket = movieService.getById(movieScheduleEntityToTicket.getMovieId());
            SeatEntity seatToTicket = seatsService.getById(ticketEntity.getSeatId());
            HallEntity hallEntity = hallsService.getById(movieScheduleEntityToTicket.getHallId());
            Ticket ticket = new Ticket(movieToTicket.getName(), hallEntity.getHallColour(), movieScheduleEntityToTicket.getMovieDate(),
                    movieScheduleEntityToTicket.getMovieTime(), movieScheduleEntityToTicket.getPrice(), seatToTicket.getSeatNumber(),
                    seatToTicket.getSeatType());
            pageNumber++;
            ticket.setPageNumber(pageNumber);
            tickets.add(ticket);
        }

        model.addAttribute("tickets", tickets);
        return "ticket";
    }
}
