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
public class EmployeeRegisterDTO {

    @NotBlank(message = "The firstName is required.")
    private String firstName;
    @NotBlank(message = "The lastName is required.")
    private String lastName;
    private Integer phoneNumber;

    @NotBlank(message = "The email address is required.")
    @Email(message = "The email address is invalid.", flags = { Pattern.Flag.CASE_INSENSITIVE })
    private String email;
    @NotBlank(message = "The  password is required.")
    private String password;
    @NotNull(message = "The  salary is required.")
    private Integer salary;

    @NotNull(message = "The  gender is required.")
    private Gender gender;
    @NotNull(message = "The  role is required.")
    private Role role;
    @NotNull(message = "The  hotel information is required.")
    private HotelEntity hotel;



    public EmployeeEntity createUserEntity() {
            return new EmployeeEntity(firstName, lastName, phoneNumber,
                          email, password, salary, gender,
                          role, hotel);

    }
}
