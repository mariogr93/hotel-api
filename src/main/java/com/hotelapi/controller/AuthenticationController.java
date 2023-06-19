package com.hotelapi.controller;


import com.hotelapi.model.entity.ImageEntity;
import com.hotelapi.model.request.ClientRegisterDTO;
import com.hotelapi.model.request.EmployeeRegisterDTO;
import com.hotelapi.model.request.UserLoginDTO;
import com.hotelapi.model.response.GeneralResponse;
import com.hotelapi.model.response.UserLoginResponse;
import com.hotelapi.service.AuthenticationService;
import com.hotelapi.service.ImageService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authService;
    private final ImageService imgService;

//    task: delimitate access with role and permission validations

    @PostMapping("img")
    public ResponseEntity<?> uploadImage(@RequestParam("image") MultipartFile file) throws IOException {
        String uploadImage = imgService.uploadImage(file);
        return ResponseEntity.status(HttpStatus.OK)
                .body(uploadImage);
    }

    @GetMapping("img/{roomid}")
    public ResponseEntity<?> downloadImage(@PathVariable Integer roomid){
        byte[] imageData = imgService.downloadAllRoomImages(roomid);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(imageData);

    }

    @PostMapping("employee/register")
    public ResponseEntity<GeneralResponse> registrer(@RequestBody @Valid EmployeeRegisterDTO employee) {
        return ResponseEntity.ok(GeneralResponse.builder()
                        .timeStamp(LocalDateTime.now())
                        .message("User registered succesfuly!")
                        .status(HttpStatus.CREATED)
                        .statusCode(HttpStatus.CREATED.value())
                        .data(Map.of("user", this.authService.registerEmployee(employee)))
                        .build());
    }

    @PostMapping("employee/login")
    public ResponseEntity<GeneralResponse> login(@RequestBody @Valid UserLoginDTO employee) {
        UserLoginResponse authenticatedEmployee = this.authService.authenticateEmployee(employee);
        return ResponseEntity.ok(
                GeneralResponse.builder()
                        .message("User logged in")
                        .data(Map.of("user", authenticatedEmployee))
                        .statusCode(HttpStatus.FOUND.value())
                        .status(HttpStatus.FOUND)
                        .timeStamp(LocalDateTime.now())
                        .build()
        );
    }

    @PostMapping("client/register")
    public ResponseEntity<GeneralResponse> clientRegistrer(@RequestBody @Valid ClientRegisterDTO client) {
        return ResponseEntity.ok(GeneralResponse.builder()
                .timeStamp(LocalDateTime.now())
                .message("User registered succesfuly!")
                .status(HttpStatus.CREATED)
                .statusCode(HttpStatus.CREATED.value())
                .data(Map.of("user", this.authService.registerClient(client)))
                .build());
    }

    @PostMapping("client/login")
    public ResponseEntity<GeneralResponse> clientLogin(@RequestBody @Valid UserLoginDTO client) {
        UserLoginResponse authenticatedEmployee = this.authService.authenticateClient(client);
        return ResponseEntity.ok(
                GeneralResponse.builder()
                        .message("User logged in")
                        .data(Map.of("user", authenticatedEmployee))
                        .statusCode(HttpStatus.FOUND.value())
                        .status(HttpStatus.FOUND)
                        .timeStamp(LocalDateTime.now())
                        .build()
        );
    }
}
