package com.chemicalgears.chemicalapi.controller;

import com.chemicalgears.chemicalapi.entity.UserCredentials;
import com.chemicalgears.chemicalapi.service.UserCredentialsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserCredentialsController {

    private final UserCredentialsService userCredentialsService;

    UserCredentialsController(UserCredentialsService userCredentialsService) {
        this.userCredentialsService = userCredentialsService;
    }

    @GetMapping("/{id}")
    public UserCredentials findById(@PathVariable Long id) {
        return userCredentialsService.findById(id);
    }

    @PostMapping("/signup")
    public void registerOrLoginUser(@RequestBody UserCredentials userCredentials) {
        userCredentialsService.registerUser(userCredentials);
    }
}
