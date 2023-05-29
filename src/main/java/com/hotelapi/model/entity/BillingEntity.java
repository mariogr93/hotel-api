package com.hotelapi.model.entity;


import com.hotelapi.model.enums.PaymentMethod;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "bills")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BillingEntity {

    @Id
    @SequenceGenerator(
            name = "billing_sequence",
            sequenceName = "billing_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "billing_sequence"
    )
    private Integer id;
    private Integer roomCharge;
    private Integer restaurantCharge;
    private Integer barCharge;
    private LocalDateTime paymentDate;
    private String arrivalDate;
    private String departureDate;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @ManyToOne
    @JoinColumn
    private ClientEntity client;

    @ManyToOne
    @JoinColumn
    private BookingEntity booking;

    public BillingEntity(Integer roomCharge, Integer restaurantCharge, Integer barCharge, LocalDateTime paymentDate, PaymentMethod paymentMethod, String arrivalDate, String departureDate, ClientEntity client, BookingEntity booking) {
        this.roomCharge = roomCharge;
        this.restaurantCharge = restaurantCharge;
        this.barCharge = barCharge;
        this.paymentDate = paymentDate;
        this.paymentMethod = paymentMethod;
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
        this.client = client;
        this.booking = booking;
    }

}


