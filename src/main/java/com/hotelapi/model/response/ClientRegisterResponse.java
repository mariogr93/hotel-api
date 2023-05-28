package com.hotelapi.model.response;


import com.hotelapi.model.entity.BookingEntity;
import com.hotelapi.model.enums.Gender;
import com.hotelapi.model.enums.Role;
import lombok.Builder;
import lombok.Data;

@Data
public class ClientRegisterResponse  extends UserRegisterResponse{

    private String passportNumber;

    public ClientRegisterResponse() {
        super();
    }

    public ClientRegisterResponse(String passportNumber, BookingEntity booking) {
        this.passportNumber = passportNumber;
    }

    @Builder
    public ClientRegisterResponse(Integer id, String firstName, String lastName, Integer phoneNumber, String email, Gender gender, Role role, String passportNumber) {
        super(id, firstName, lastName, phoneNumber, email, gender, role);
        this.passportNumber = passportNumber;
    }
}
