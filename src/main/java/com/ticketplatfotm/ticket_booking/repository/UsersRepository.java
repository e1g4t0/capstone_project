package com.ticketplatfotm.ticket_booking.repository;

import com.ticketplatfotm.ticket_booking.repository_entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);
    UserEntity findByEmail(String email);
    UserEntity findByTelephone(String telephone);
}
