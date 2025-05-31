package org.jagdish_prac.auth_service.controller;

import org.jagdish_prac.auth_service.security.JwtUtil;
import org.jagdish_prac.auth_service.entity.User;
import org.jagdish_prac.auth_service.repository.UserRepository;
import org.jagdish_prac.auth_service.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/auth")
//@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AuthController {


    private final UserRepository userRepository;


    private final JwtUtil jwtUtil;

    public AuthController(UserRepository userRepository, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        userRepository.save(user);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        var dbUser = userRepository.findByUsername(user.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!dbUser.getPassword().equals(user.getPassword())) {
            return ResponseEntity.status(401).body("Invalid credentials");
        }

        String token = jwtUtil.generateToken(dbUser.getUsername(), dbUser.getRole());
        return ResponseEntity.ok(Collections.singletonMap("token", token));
    }
}
