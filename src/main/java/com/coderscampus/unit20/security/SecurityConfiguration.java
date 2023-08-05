package com.coderscampus.unit20.security;

import com.coderscampus.unit20.repository.UserRepository;
import com.coderscampus.unit20.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.security.AuthProvider;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    private UserRepository userRepo;

    public SecurityConfiguration(UserRepository userRepo) {
        super();
        this.userRepo = userRepo;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserService(userRepo);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((request) -> {
            request.requestMatchers("/api/v1/users").permitAll()


                    //.requestMatchers("/products")
                    .anyRequest().authenticated(); //hasAnyRole("USER")
//                    .requestMatchers("/api/v1/users").permitAll();

        })      .formLogin(Customizer.withDefaults());
        return http.build();
    }

    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService());
        return daoAuthenticationProvider;
    }
}
