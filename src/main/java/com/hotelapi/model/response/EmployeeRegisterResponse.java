package com.hotelapi.model.response;

import com.hotelapi.model.entity.HotelEntity;

import com.hotelapi.model.enums.Gender;
import com.hotelapi.model.enums.Role;
import lombok.Builder;
import lombok.Data;
@Data
public class EmployeeRegisterResponse extends UserRegisterResponse{

    private Integer salary;
    private HotelEntity hotel;

    public EmployeeRegisterResponse(Integer salary, HotelEntity hotel) {
        super();
        this.salary = salary;
        this.hotel = hotel;
    }

    @Builder
    public EmployeeRegisterResponse(Integer id, String firstName, String lastName, Integer phoneNumber, String email, Gender gender, Role role, Integer salary, HotelEntity hotel) {
        super(id, firstName, lastName, phoneNumber, email, gender, role);
        this.salary = salary;
        this.hotel = hotel;
    }
}
