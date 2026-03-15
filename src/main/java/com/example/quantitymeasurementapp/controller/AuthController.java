package com.example.quantitymeasurementapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.quantitymeasurementapp.dto.request.LoginRequest;
import com.example.quantitymeasurementapp.dto.response.LoginResponse;
import com.example.quantitymeasurementapp.dto.response.SignupResponse;
import com.example.quantitymeasurementapp.service.AuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth/")
@RequiredArgsConstructor
public class AuthController {

	@Autowired
    private  AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(authService.login(loginRequest));
    }

    @PostMapping("/signup")
    public ResponseEntity<SignupResponse> signup(@RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(authService.signup(loginRequest));
    }
}
