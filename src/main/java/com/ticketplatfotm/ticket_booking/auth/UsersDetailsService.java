package com.ticketplatfotm.ticket_booking.auth;

import com.ticketplatfotm.ticket_booking.repository_entity.UserEntity;
import com.ticketplatfotm.ticket_booking.repository.UsersRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsersDetailsService implements UserDetailsService {

    private UsersRepository usersRepository;

    public UsersDetailsService(UsersRepository usersRepository) {
        super();
        this.usersRepository = usersRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = usersRepository.findByUsername(username);

        if(null == user){
            throw new UsernameNotFoundException("cannot find user");
        }
        return new UserPrincipal(user);
    }
}
