package com.hotelapi.model.entity;


import com.hotelapi.model.enums.PaymentMethod;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "bills")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BillEntity {

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

    private String paymentDate;
    private String arraivalDate;
    private String departureDate;


    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @ManyToOne
    @JoinColumn
    private ClientEntity client;

    @ManyToOne
    @JoinColumn
    private BookingEntity booking;


}


