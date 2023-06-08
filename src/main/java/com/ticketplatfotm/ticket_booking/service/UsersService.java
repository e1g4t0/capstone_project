package com.ticketplatfotm.ticket_booking.service;

import com.ticketplatfotm.ticket_booking.repository_entity.UserEntity;
import com.ticketplatfotm.ticket_booking.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;

    public UsersService() {
    }

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public List<UserEntity> findAllUsers(){
        return usersRepository.findAll();
    }

    public UserEntity findByUsername(String username){
        return usersRepository.findByUsername(username);
    }

    public UserEntity findByEmail(String email){
        return usersRepository.findByEmail(email);
    }

    public UserEntity findByTelephone(String telephone){
        return usersRepository.findByTelephone(telephone);
    }

    public void saveUser(UserEntity user){

        user.setRole("USER");

        usersRepository.save(user);
    }
}
