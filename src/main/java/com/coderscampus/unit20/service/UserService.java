package com.coderscampus.unit20.service;

import com.coderscampus.unit20.domain.User;
import com.coderscampus.unit20.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserService implements UserDetailsService {

    private UserRepository userRepo;

    public UserService(UserRepository userRepo) {
        super();
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepo.findByUsername(username);

        if (user == null) throw new UsernameNotFoundException("Username Not Found");

        return user;
    }
}
