package com.jobportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.jobportal.model.User;
import com.jobportal.repository.UserRepository;

@RestController
@CrossOrigin(origins = "*")   // allows frontend to connect
public class AuthController {

    @Autowired
    private UserRepository userRepo;

    @PostMapping("/signup")
    public String signup(@RequestBody User user) {
        userRepo.save(user);
        return "User Registered Successfully";
    }

    @PostMapping("/signin")
    public User signin(@RequestBody User user) {
        User found = userRepo.findByEmailAndPassword(
                user.getEmail(),
                user.getPassword()
        );

        if(found != null) {
            return found;
        } else {
            return null;
        }
    }
}
