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
    @NotNull(message = "The client is required.")
    private ClientEntity client;
    @NotNull(message = "The room is required.")
    private RoomEntity roomEntity;


    public BookingEntity createBookingEntity(){
        return new BookingEntity(date, arraivalDate, departureDate, numberOfAdults, numberOfChildren, client, roomEntity, roomEntity.getHotel());
    }
}
