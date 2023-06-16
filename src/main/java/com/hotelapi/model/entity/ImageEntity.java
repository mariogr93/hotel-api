package com.hotelapi.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ImageData")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ImageEntity {


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

        private String name;
        private String type;
        @Lob
        @Column(name = "imagedata",length = 1000)
        private byte[] imageData;

}
