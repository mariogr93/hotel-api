package com.hotelapi.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BookingEntity {

    @Id
    @SequenceGenerator(
            name = "booking_sequence",
            sequenceName = "booking_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "booking_sequence"
    )
    private Integer id;

    private String date;
    private String arraivalDate;
    private String departureDate;
    private Integer numberOfAdults;
    private Integer numberOfChildren;



//    create guest entity
    private String guest;
    @ManyToOne
    @JoinColumn(name = "room")
    private RoomEntity roomEntity;

    @ManyToOne
    @JoinColumn(name ="hotel")
    private HotelEntity hotel;

}
