package com.hotelapi.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;

@Entity
@Table(name = "ImageData")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ImageEntity {


        @Id
        @SequenceGenerator(
                name = "img_sequence",
                sequenceName = "img_sequence",
                allocationSize = 1
        )
        @GeneratedValue(
                strategy = GenerationType.SEQUENCE,
                generator = "img_sequence"
        )
        private Integer id;

        private String name;
        private String type;
        @Lob
        @Column(name = "imagedata",length = 1000)
        private byte[] imageData;

        @ManyToOne
        @JoinColumn(name = "room")
        private RoomEntity roomEntity;

        public ImageEntity(String name, String type, byte[] imageData, RoomEntity roomEntity) {
                this.name = name;
                this.type = type;
                this.imageData = imageData;
                this.roomEntity = roomEntity;
        }

        @Override
        public String toString() {
                return "ImageEntity{" +
                        "name='" + name + '\'' +
                        ", type='" + type + '\'' +
                        ", imageData=" + Arrays.toString(imageData) +
                        '}';
        }
}
