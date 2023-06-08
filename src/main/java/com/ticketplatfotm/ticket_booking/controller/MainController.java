package com.ticketplatfotm.ticket_booking.controller;

import com.ticketplatfotm.ticket_booking.repository_entity.UserEntity;
import com.ticketplatfotm.ticket_booking.service.ActorsService;
import com.ticketplatfotm.ticket_booking.service.UsersService;
import jakarta.validation.Valid;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    private final ActorsService actorsService;
    private final UsersService usersService;
    private final BCryptPasswordEncoder passwordEncoder;

    private final static String EMAIL_REGEX_VALIDATION = "^[a-zA-Z0-9.!#$%&'*+=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";

    public MainController(ActorsService actorsService, UsersService usersService, BCryptPasswordEncoder passwordEncoder) {
        this.actorsService = actorsService;
        this.usersService = usersService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/actors")
    public String ListAllActors(Model model) {
        model.addAttribute("message", "dsgdfgsdfg");
        model.addAttribute("tasks", actorsService.findAllActors());

        return "actors";
    }

    @GetMapping("/users")
    public String ListAllUsers(Model model) {
        model.addAttribute("message", "dsgdfgsdfg");
        model.addAttribute("tasks", usersService.findAllUsers());

        return "users";
    }

    @GetMapping(value={"/", "/index"})
    public String getHomePage(Model model){

        return "index";
    }

    @GetMapping("/login")
    public String getLoginPage(Model model){
        return "login";
    }
    @GetMapping(value="/logout-success")
    public String getLogoutPage(Model model){
        return "logout";
    }

    @GetMapping("/register")
    public String getRegisterpage(Model model){
        UserEntity user = new UserEntity();

        try{
            model.addAttribute("user", user);
        } catch (Exception e){
            e.printStackTrace();
        }

        return "register";
    }

    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") UserEntity user,
                               BindingResult result,
                               Model model) {
        UserEntity existingUserByUsername = usersService.findByUsername(user.getUsername());
        UserEntity existingUserByEmail = usersService.findByEmail(user.getEmail());
        UserEntity existingUserByTelephone = usersService.findByTelephone(user.getTelephone());

        if(existingUserByUsername != null && existingUserByUsername.getUsername() != null && !existingUserByUsername.getUsername().isEmpty()){
            result.rejectValue("username", null,
                    "There is already an account registered with that username");
        }
        if (existingUserByEmail != null && existingUserByEmail.getEmail() != null && !existingUserByEmail.getEmail().isEmpty()
                && existingUserByEmail.getEmail().equals(user.getEmail())){
            result.rejectValue("email", null,
                    "There is already an account registered with that email");
        }
        if (existingUserByTelephone != null && existingUserByTelephone.getTelephone() != null && !existingUserByTelephone.getTelephone().isEmpty()
                && existingUserByTelephone.getTelephone().equals(user.getTelephone())){
            result.rejectValue("telephone", null,
                    "There is already an account registered with that telephone");
        } else if (!user.getTelephone().isEmpty() && user.getTelephone().length() != 11 || !user.getTelephone().matches("\\d*")) {
            result.rejectValue("telephone", null,
                    "Invalid telephone number");
        }

        boolean isEmail = user.getEmail().matches(EMAIL_REGEX_VALIDATION);
        if (!isEmail && !user.getEmail().isEmpty()){
            result.rejectValue("email", null,
                     "This is not an email address!");
        }

        if(result.hasErrors()){
            System.out.println(result);
            model.addAttribute("user", user);
            return "/register";
        }


        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("USER");
        usersService.saveUser(user);
        return "redirect:/register?success";
    }
}
