package com.hotelapi.model.response;

import com.hotelapi.model.enums.PaymentMethod;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class BillingPaymentResponse {
    private Integer id;
    private Integer roomCharge;
    private Integer restaurantCharge;
    private Integer barCharge;
    private LocalDateTime paymentDate;
    private String arrivalDate;
    private String departureDate;
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    private Integer clientId;
    private String clientFirstName;
    private String clientLastName;
    private Integer roomId;
    private Integer roomNumber;
    private String hotelRoomCode;



}
