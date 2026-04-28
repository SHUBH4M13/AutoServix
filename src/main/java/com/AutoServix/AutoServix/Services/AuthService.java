package com.AutoServix.AutoServix.Services;

import com.AutoServix.AutoServix.DTO.AuthResponse;
import com.AutoServix.AutoServix.DTO.LoginRequest;
import com.AutoServix.AutoServix.DTO.RegisterRequest;
import com.AutoServix.AutoServix.Models.CustomerModel;
import com.AutoServix.AutoServix.Repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

public class AuthService {

    @Autowired
    private CustomerRepo customerRepo;

    private PasswordEncoder passwordEncoder;

    @Autowired
    private Jwtservice jwtservice;

    public AuthResponse register (RegisterRequest request) {
        CustomerModel customer = new CustomerModel(null, request.getName() , request.getEmail(), request.getPassword());
        customerRepo.save(customer);

        String token = jwtservice.generateToken(request.getEmail());
        return new AuthResponse(token);
    }

    public AuthResponse login(LoginRequest request) {
        CustomerModel customer = customerRepo.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User Not Found"));

        if (! passwordEncoder.matches(request.getPassword(), customer.getPassword())) {
            throw new RuntimeException("Invalid Password");
        }

        String token = jwtservice.generateToken(customer.getEmail());
        return new AuthResponse(token);
    }

}