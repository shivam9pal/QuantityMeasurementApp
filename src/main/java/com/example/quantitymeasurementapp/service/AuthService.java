package com.example.quantitymeasurementapp.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.quantitymeasurementapp.dto.request.LoginRequest;
import com.example.quantitymeasurementapp.dto.response.LoginResponse;
import com.example.quantitymeasurementapp.dto.response.SignupResponse;
import com.example.quantitymeasurementapp.entity.User;
import com.example.quantitymeasurementapp.repository.UserRepository;
import com.example.quantitymeasurementapp.security.AuthUtil;

@Service

public class AuthService {

    private AuthenticationManager authenticationManager;
    private AuthUtil authUtil;
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public AuthService(AuthenticationManager authenticationManager,
            AuthUtil authUtil,
            UserRepository userRepository,
            PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.authUtil = authUtil;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    //login request 
    public LoginResponse login(LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
        );

        User user = (User) authentication.getPrincipal();

        String jwtToken = authUtil.genrateAccessToken(user);
        return new LoginResponse(jwtToken, user.getId());
    }

    //signup request 
    public SignupResponse signup(LoginRequest signupRequest) {
        User user = userRepository.findByUsername(signupRequest.getUsername()).orElse(null);

        if (user != null) {
            throw new IllegalArgumentException("User already Exists ...!");
        }

        // Encode password before saving
        String encodedPassword = passwordEncoder.encode(signupRequest.getPassword());
        user = userRepository.save(new User(signupRequest.getUsername(), encodedPassword));

        return new SignupResponse(user.getId(), user.getUsername());
    }

}
