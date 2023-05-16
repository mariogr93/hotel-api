package com.hotelapi.model.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "hotel")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class HotelEntity {

    @Id
    @SequenceGenerator(
            name = "hotel_sequence",
            sequenceName = "hotel_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "hotel_sequence"
    )
    private Integer id;
    private String hotelName;
    private String address;
    private String city;
    private String country;
}
