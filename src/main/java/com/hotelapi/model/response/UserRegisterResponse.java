package com.hotelapi.model.response;


import com.hotelapi.model.enums.Gender;
import com.hotelapi.model.enums.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Data
public class UserRegisterResponse {

    private Integer id;
    private String firstName;
    private String lastName;
    private Integer phoneNumber;
    private String email;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Enumerated(EnumType.STRING)
    private Role role;

    public UserRegisterResponse() { }

    public UserRegisterResponse(Integer id, String firstName, String lastName, Integer phoneNumber, String email, Gender gender, Role role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.gender = gender;
        this.role = role;
    }

}
