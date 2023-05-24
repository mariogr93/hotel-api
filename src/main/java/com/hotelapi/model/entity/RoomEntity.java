package com.hotelapi.model.entity;

import com.hotelapi.model.enums.RoomType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "rooms")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RoomEntity {

    @Id
    @SequenceGenerator(
            name = "room_sequence",
            sequenceName = "room_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "room_sequence"
    )
    private Integer id;
    private Integer roomNumber;
    private String hotelRoomCode;
    private Boolean occupancy;
    @ManyToOne
    @JoinColumn(name = "hotel")
    private HotelEntity hotel;
    @ManyToOne
    @JoinColumn(name = "room_type")
    private RoomTypeEntity roomType;

    public RoomEntity(Integer roomNumber, String hotelRoomCode, Boolean occupancy, HotelEntity hotel, RoomTypeEntity roomType) {
        this.roomNumber = roomNumber;
        this.hotelRoomCode = hotelRoomCode;
        this.occupancy = occupancy;
        this.hotel = hotel;
        this.roomType = roomType;
    }

    @Override
    public String toString() {
        return "RoomEntity{" +
                "id=" + id +
                ", roomNumber=" + roomNumber +
                ", hotelRoomCode='" + hotelRoomCode + '\'' +
                ", occupancy=" + occupancy +
                ", hotel=" + hotel +
                ", roomType=" + roomType +
                '}';
    }
}
