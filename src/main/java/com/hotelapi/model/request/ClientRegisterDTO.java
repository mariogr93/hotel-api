package com.hotelapi.model.request;

import com.hotelapi.model.entity.BookingEntity;
import com.hotelapi.model.entity.ClientEntity;
import com.hotelapi.model.enums.Gender;
import com.hotelapi.model.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class ClientRegisterDTO extends  UserRegisterDTO {
    @NotBlank(message = "The  passport number is required.")
    private String passportNumber;
    //@NotNull(message = "The  booking information is required.")
    private BookingEntity booking;


    public ClientEntity createUserEntity() {
        return new ClientEntity(getFirstName(), getLastName(), getPhoneNumber(),
                getEmail(), getPassword(), passportNumber, getGender(),
                getRole());

    }
}
