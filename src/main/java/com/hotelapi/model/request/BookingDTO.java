package com.hotelapi.model.request;

import com.hotelapi.model.entity.BookingEntity;
import com.hotelapi.model.entity.ClientEntity;
import com.hotelapi.model.entity.HotelEntity;
import com.hotelapi.model.entity.RoomEntity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BookingDTO {

    @NotBlank(message = "The date is required.")
    private String date;
    @NotBlank(message = "The  arraival date is required.")
    private String arraivalDate;
    @NotBlank(message = "The  departure date is required.")
    private String departureDate;
    @NotNull(message = "The  number of adults is required.")
    private Integer numberOfAdults;
    @NotNull(message = "The  number of children is required.")
    private Integer numberOfChildren;
    @NotNull(message = "The room is required.")
    private ClientEntity client;
    @NotNull(message = "The room is required.")
    private RoomEntity roomEntity;
//    @NotNull(message = "The  hotel is required.")
//    private HotelEntity hotel;

    public BookingEntity createBookingEntity(){
        return new BookingEntity(date, arraivalDate, departureDate, numberOfAdults, numberOfChildren, client, roomEntity, roomEntity.getHotel());
    }
}


//{
//        "date":"01-01-2024",
//        "arraivalDate":"01-01-2024",
//        "departureDate":"01-01-2024",
//        "numberOfAdults":2,
//        "numberOfChildren":0,
//        "roomEntity":{"id":1, "roomNumber":11, "hotelRoomCode":"a-single-1", "occupancy":false, "hotel":{"id":1, "hotelName":"hotel 5 stars", "address":"address", "city":"samana city", "country":"Dom Rep"}, "roomType": {"id":1, "roomType": "SINGLE_BED", "roomPrice": 30, "roomCapacity": 2}},
//        "hotel":{
//        "id":1,
//        "hotelName":"hotel 5 stars",
//        "address":"address",
//        "city":"samana city",
//        "country":"Dom Rep"
//        }
//        }
