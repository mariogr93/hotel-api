package com.hotelapi.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "bookings")
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

    @ManyToOne
    @JoinColumn(name = "client_id")
    private ClientEntity clientEntity;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private RoomEntity roomEntity;

    @ManyToOne
    @JoinColumn(name ="hotel_id")
    private HotelEntity hotel;

    public BookingEntity(String date, String arraivalDate, String departureDate, Integer numberOfAdults, Integer numberOfChildren,ClientEntity clientEntity, RoomEntity roomEntity, HotelEntity hotel) {
        this.date = date;
        this.arraivalDate = arraivalDate;
        this.departureDate = departureDate;
        this.numberOfAdults = numberOfAdults;
        this.numberOfChildren = numberOfChildren;
        this.clientEntity = clientEntity;
        this.roomEntity = roomEntity;
        this.hotel = hotel;
    }
}
