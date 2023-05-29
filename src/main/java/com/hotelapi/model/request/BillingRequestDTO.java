package com.hotelapi.model.request;

import com.hotelapi.model.entity.BookingEntity;
import com.hotelapi.model.entity.ClientEntity;
import com.hotelapi.model.enums.PaymentMethod;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BillingRequestDTO {
//    @NotNull(message = "The room charge amount is required.")
//    private Integer roomCharge;
    @NotNull(message = "The restaurant charge amount is required.")
    private Integer restaurantCharge;
    @NotNull(message = "The bar charge amount is required.")
    private Integer barCharge;

//    @NotBlank(message = "The payment date is required.")
//    private String paymentDate;
//    @NotBlank(message = "The  arrival date is required.")
//    private String arrivalDate;
//    @NotBlank(message = "The  departure date is required.")
//    private String departureDate;

    @NotNull(message = "The payment method is required.")
    private PaymentMethod paymentMethod;

    @NotNull(message = "The client information is required.")
    private ClientEntity client;
    @NotNull(message = "The booking information is required.")
    private BookingEntity booking;
}
