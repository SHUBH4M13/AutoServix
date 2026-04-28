package com.AutoServix.AutoServix.Services;

import com.AutoServix.AutoServix.DTO.AuthResponse;
import com.AutoServix.AutoServix.DTO.LoginRequest;
import com.AutoServix.AutoServix.DTO.RegisterRequest;
import com.AutoServix.AutoServix.Models.CustomerModel;
import com.AutoServix.AutoServix.Repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private Jwtservice jwtservice;

    public AuthResponse register (RegisterRequest request) {

        String encodedpassword = passwordEncoder.encode(request.getPassword());

        CustomerModel customer = new CustomerModel(
                request.getName(),
                request.getEmail(),
                encodedpassword,
                request.getModelNo(),
                request.getBrand(),
                request.getChassisNo()
        );
        customerRepo.save(customer);

        String token = jwtservice.generateToken(request.getEmail());
        return new AuthResponse(token);
    }

    public AuthResponse login(LoginRequest request) {
        CustomerModel customer = customerRepo.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User Not Found"));

        if (!passwordEncoder.matches(request.getPassword(), customer.getPassword())) {
            throw new RuntimeException("Invalid Password");
        }

        String token = jwtservice.generateToken(customer.getEmail());
        return new AuthResponse(token);
    }

}
