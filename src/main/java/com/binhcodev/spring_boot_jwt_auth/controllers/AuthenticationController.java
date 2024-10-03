package com.binhcodev.spring_boot_jwt_auth.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.binhcodev.spring_boot_jwt_auth.dtos.LoginUserDto;
import com.binhcodev.spring_boot_jwt_auth.dtos.RegisterUserDto;
import com.binhcodev.spring_boot_jwt_auth.entities.User;
import com.binhcodev.spring_boot_jwt_auth.responses.LoginResponse;
import com.binhcodev.spring_boot_jwt_auth.services.AuthenticationService;
import com.binhcodev.spring_boot_jwt_auth.services.JwtService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RequestMapping("/auth")
@RestController
public class AuthenticationController {
    private final JwtService jwtService;
    private final AuthenticationService authenticationService;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public ResponseEntity<User> register(@RequestBody RegisterUserDto registerUserDto) {
        User registerUser = authenticationService.signup(registerUserDto);
        return ResponseEntity.ok(registerUser);
    }
    
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginUserDto loginUserDto) {
        User authenticatedUser = authenticationService.authenticate(loginUserDto);
        String token = jwtService.generateToken(authenticatedUser);
        LoginResponse loginResponse = new LoginResponse().setToken(token).setExpireIn(jwtService.getExpirationTime());
        return ResponseEntity.ok(loginResponse);
    }
}
