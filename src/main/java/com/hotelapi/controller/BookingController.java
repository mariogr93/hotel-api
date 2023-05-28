package com.hotelapi.controller;


import com.hotelapi.model.entity.BookingEntity;
import com.hotelapi.model.request.BookingDTO;
import com.hotelapi.model.response.GeneralResponse;
import com.hotelapi.service.BookingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("api/v1/booking")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping
    public ResponseEntity<GeneralResponse> booking(@RequestBody @Valid BookingDTO bookingDTO){

        // <--------------------------------------->
        // TO DO:CREATE BILL ENTITY...
        // <--------------------------------------->
        // <--------------------------------------->
        // TO DO:VALIDATE DATES AVAILABLES FOR BOOKING...
        // <--------------------------------------->


        return ResponseEntity.ok(GeneralResponse.builder()
                .timeStamp(LocalDateTime.now())
                .message("Room booked succesfuly!")
                .status(HttpStatus.CREATED)
                .statusCode(HttpStatus.CREATED.value())
                .data(Map.of("booking", this.bookingService.createBooking(bookingDTO)))
                .build());
    }

    @GetMapping
    public ResponseEntity<GeneralResponse> getAllBookings(){
        return ResponseEntity.ok(GeneralResponse.builder()
                .timeStamp(LocalDateTime.now())
                .message("Room booked succesfuly!")
                .status(HttpStatus.CREATED)
                .statusCode(HttpStatus.CREATED.value())
                .data(Map.of("bookings", this.bookingService.getAllBookings() ))
                .build());
    }

    @GetMapping(path = "/client/{id}")
    public ResponseEntity<GeneralResponse> getAllBookingsByClientId(@PathVariable Integer id){
        return ResponseEntity.ok(GeneralResponse.builder()
                .timeStamp(LocalDateTime.now())
                .message("Bookings found!")
                .status(HttpStatus.FOUND)
                .statusCode(HttpStatus.FOUND.value())
                .data(Map.of("bookings", this.bookingService.getAllBookingsByClientId(id) ))
                .build());
    }
}

