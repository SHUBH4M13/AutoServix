package com.AutoServix.AutoServix.Controller;

import com.AutoServix.AutoServix.DTO.AuthResponse;
import com.AutoServix.AutoServix.DTO.LoginRequest;
import com.AutoServix.AutoServix.DTO.RegisterRequest;
import com.AutoServix.AutoServix.Services.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/auth")
@RestController
public class AuthController {

    private AuthService authService;

    @PostMapping("/register")
    public AuthResponse register(@RequestBody RegisterRequest registerRequest){
        return authService.register(registerRequest);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest loginRequest){
        return authService.login(loginRequest);
    }

}
