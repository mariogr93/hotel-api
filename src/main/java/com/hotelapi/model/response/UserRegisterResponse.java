package com.hotelapi.model.response;


import com.hotelapi.config.security.UserDetailsImpl;
import lombok.Data;

@Data
public class UserRegisterResponse {

    private String message;
    private UserDetailsImpl user;

}
