package com.hotelapi.controller;


import com.hotelapi.model.request.UserLoginDTO;
import com.hotelapi.model.request.UserRegisterDTO;
import com.hotelapi.model.response.GeneralResponse;
import com.hotelapi.model.response.UserLoginResponse;
import com.hotelapi.service.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authService;

    @PostMapping("/register")
    public ResponseEntity<GeneralResponse> registrer(@RequestBody @Valid UserRegisterDTO user) {
        return ResponseEntity.ok(GeneralResponse.builder()
                        .timeStamp(LocalDateTime.now())
                        .message("User registered succesfuly!")
                        .status(HttpStatus.CREATED)
                        .statusCode(HttpStatus.CREATED.value())
                        .data(Map.of("user", this.authService.registerUser(user)))
                        .build());
    }

    @PostMapping("/login")
    public ResponseEntity<GeneralResponse> login(@RequestBody @Valid UserLoginDTO user) {
        UserLoginResponse authenticatedUser = this.authService.authenticateUser(user);

        return ResponseEntity.ok(
                GeneralResponse.builder()
                        .message("User logged in")
                        .data(Map.of("user", authenticatedUser))
                        .statusCode(HttpStatus.FOUND.value())
                        .status(HttpStatus.FOUND)
                        .timeStamp(LocalDateTime.now())
                        .build()
        );
    }

}
