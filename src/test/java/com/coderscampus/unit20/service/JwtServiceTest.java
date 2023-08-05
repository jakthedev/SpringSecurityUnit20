package com.coderscampus.unit20.service;

import com.coderscampus.unit20.domain.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.fail;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//@SpringBootTest
public class JwtServiceTest {

    //@Autowired
    private static JwtService sut;

    @BeforeAll
    static void init() {
    sut = new JwtService();
    }

    @Test
    void testGenerateToken() {
        // Arrage
        // Act
        // Assert

        //Arrange
        Map<String, Object> extraClaims = new HashMap<>();
        User user = new User("jdakemp@gmail.com", "Alex123");

        //Act
        String jwt = sut.generateToken(extraClaims, user);

        //Assert
        System.out.println(jwt);

    }
}
