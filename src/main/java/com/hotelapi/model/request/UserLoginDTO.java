package com.hotelapi.model.request;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class UserLoginDTO {

    @NotBlank(message = "The email address is required.")
    @Email(message = "The email address is invalid.", flags = { Pattern.Flag.CASE_INSENSITIVE })
    private String email;
    @NotBlank(message = "The  password is required.")
    private String password;
}
