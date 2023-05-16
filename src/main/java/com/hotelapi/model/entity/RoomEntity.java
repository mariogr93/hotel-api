package com.hotelapi.model.entity;

import com.hotelapi.model.enums.RoomType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "rooms")
@Setter
@Getter
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
    @JoinColumn(name = "room_type")
    private RoomTypeEntity roomType;
}
