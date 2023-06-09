package com.hotelapi.model.entity;


import com.hotelapi.model.enums.RoomType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "room_types")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RoomTypeEntity {

    @Id
    @SequenceGenerator(
            name = "room_type_sequence",
            sequenceName = "room_type_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "room_type_sequence"
    )
    private Integer id;
    @Enumerated(EnumType.STRING)
    private RoomType roomType;
    private Integer roomPrice;
    private Integer roomCapacity;

    public RoomTypeEntity(RoomType roomType, Integer roomPrice, Integer roomCapacity) {
        this.roomType = roomType;
        this.roomPrice = roomPrice;
        this.roomCapacity = roomCapacity;
    }

    @Override
    public String toString() {
        return "RoomTypeEntity{" +
                "id=" + id +
                ", roomType=" + roomType +
                ", roomPrice=" + roomPrice +
                ", roomCapacity=" + roomCapacity +
                '}';
    }
}
