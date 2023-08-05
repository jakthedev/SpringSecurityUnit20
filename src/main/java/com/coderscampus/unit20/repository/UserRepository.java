package com.coderscampus.unit20.repository;

import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import com.coderscampus.unit20.domain.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);

}
