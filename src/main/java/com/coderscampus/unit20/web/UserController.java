package com.coderscampus.unit20.web;


import com.coderscampus.unit20.domain.User;
import com.coderscampus.unit20.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private UserRepository userRepo;
    private PasswordEncoder passwordEncoder;

    public UserController(UserRepository userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("")
    public ResponseEntity<User> signUpUser(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User savedUser = userRepo.save(user);

        return ResponseEntity.ok(savedUser);
    }
}
