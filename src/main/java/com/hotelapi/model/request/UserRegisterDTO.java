package com.hotelapi.model.request;


import com.hotelapi.model.enums.Role;
import com.hotelapi.config.security.UserDetailsImpl;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class UserRegisterDTO {

    @NotBlank(message = "The firstName is required.")
    private String firstName;
    @NotBlank(message = "The lastName is required.")
    private String lastName;
    @NotBlank(message = "The email address is required.")
    @Email(message = "The email address is invalid.", flags = { Pattern.Flag.CASE_INSENSITIVE })
    private String email;
    @NotBlank(message = "The  password is required.")
    private String password;
    @NotNull(message = "The  role is required.")
    private Role role;

    public UserDetailsImpl createUserEntity() {
        return new UserDetailsImpl(3, firstName, lastName, email, password, role);
    }
}
