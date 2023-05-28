package com.hotelapi.model.response;


import com.hotelapi.model.entity.BookingEntity;
import com.hotelapi.model.enums.Gender;
import com.hotelapi.model.enums.Role;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ClientLoginResponse extends UserLoginResponse{

    private String passportNumber;
    private List<BookingResponse> booking;

    public ClientLoginResponse() {
        super();
    }

    @Builder
    public ClientLoginResponse(Integer id, String firstName, String lastName, Integer phoneNumber, String email, Gender gender, Role role, String token, String passportNumber, List<BookingResponse> booking) {
        super(id, firstName, lastName, phoneNumber, email, gender, role, token);
        this.passportNumber = passportNumber;
        this.booking = booking;
    }
}
