package com.jobportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.jobportal.model.User;
import com.jobportal.repository.UserRepository;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import com.jobportal.security.JwtUtil;


@RestController
@CrossOrigin(origins = "*")   // allows frontend to connect
public class AuthController {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;


    @PostMapping("/signup")
    public String signup(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepo.save(user);
        return "User Registered Successfully";
    }


    @PostMapping("/signin")
    public ResponseEntity<?> signin(@RequestBody User user) {

        User found = userRepo.findByEmail(user.getEmail());

        if (found != null && passwordEncoder.matches(user.getPassword(), found.getPassword())) {

            String token = jwtUtil.generateToken(found.getEmail());
            return ResponseEntity.ok(token);
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                            .body("Invalid Credentials");
    }

}
