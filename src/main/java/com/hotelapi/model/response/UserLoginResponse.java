package com.hotelapi.model.response;

import com.hotelapi.model.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginResponse {

    private Integer id;
    private String firstName;
    private String lastName;
    private String token;
    private String email;
    private Role role;

}
