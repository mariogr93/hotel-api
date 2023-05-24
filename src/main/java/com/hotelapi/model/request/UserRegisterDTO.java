package com.hotelapi.model.request;


import com.hotelapi.model.enums.Gender;
import com.hotelapi.model.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class UserRegisterDTO {

    private Integer phoneNumber;

    @NotBlank(message = "The first name is required.")
    private String firstName;
    @NotBlank(message = "The last name is required.")
    private String lastName;
    @NotBlank(message = "The email address is required.")
    @Email(message = "The email address is invalid.", flags = { Pattern.Flag.CASE_INSENSITIVE })
    private String email;
    @NotBlank(message = "The  password is required.")
    private String password;
    @NotNull(message = "The  role is required.")
    private Role role;
    @NotNull(message = "The  gender is required.")
    private Gender gender;

}
