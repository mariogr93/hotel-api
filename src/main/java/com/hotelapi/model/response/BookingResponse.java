package com.hotelapi.model.response;

import com.hotelapi.model.enums.RoomType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookingResponse {

    private Integer id;
    private String date;
    private String arraivalDate;
    private String departureDate;
    private Integer numberOfAdults;
    private Integer numberOfChildren;

    private Integer clientId;
    private String clientFirstName;
    private String clientLastName;

    private Integer roomId;
    private Integer roomNumber;
    private String hotelRoomCode;
    private RoomType roomType;
    private Integer roomPrice;
    private Integer roomCapacity;

    private Integer hotelId;
    private String hotelName;

}
