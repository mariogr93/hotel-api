package com.hotelapi.model.request;

import com.hotelapi.model.entity.EmployeeEntity;
import com.hotelapi.model.entity.HotelEntity;
import com.hotelapi.model.enums.Gender;
import com.hotelapi.model.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class EmployeeRegisterDTO extends  UserRegisterDTO {

    @NotNull(message = "The  salary is required.")
    private Integer salary;
    @NotNull(message = "The  hotel information is required.")
    private HotelEntity hotel;

    public EmployeeEntity createUserEntity() {
            return new EmployeeEntity(getFirstName(), getLastName(), getPhoneNumber(),
                          getEmail(), getPassword(), salary, getGender(),
                          getRole(), hotel);
    }
}
