package com.hotelapi.controller;


import com.hotelapi.model.entity.BillingEntity;
import com.hotelapi.model.request.BillingRequestDTO;
import com.hotelapi.model.response.GeneralResponse;
import com.hotelapi.service.BillingService;
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
@RequestMapping("/api/v1/billing")
@RequiredArgsConstructor
public class BillingController {

    private final BillingService billingService;


    @PostMapping
    public ResponseEntity<GeneralResponse> payBill(@RequestBody @Valid BillingRequestDTO bill) {

        return ResponseEntity.ok(GeneralResponse.builder()
                .timeStamp(LocalDateTime.now())
                .message("Payment successful!")
                .status(HttpStatus.CREATED)
                .statusCode(HttpStatus.CREATED.value())
                .data(Map.of("bill", this.billingService.generateBill(bill)))
                .build());
    }
}
