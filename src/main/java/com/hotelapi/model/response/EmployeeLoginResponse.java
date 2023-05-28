package com.hotelapi.model.response;


import com.hotelapi.model.entity.HotelEntity;
import com.hotelapi.model.enums.Gender;
import com.hotelapi.model.enums.Role;
import lombok.Builder;
import lombok.Data;


@Data
public class EmployeeLoginResponse extends UserLoginResponse{

    private Integer salary;
    private HotelEntity hotel;

    public EmployeeLoginResponse() {
       super();
    }

    public EmployeeLoginResponse( Integer salary, HotelEntity hotel) {
        super();
        this.salary = salary;
        this.hotel = hotel;
    }

    @Builder
    public EmployeeLoginResponse(Integer id, String firstName, String lastName, Integer phoneNumber, String email, Gender gender, Role role, String token, Integer salary, HotelEntity hotel) {
        super(id, firstName, lastName, phoneNumber, email, gender, role, token);
        this.salary = salary;
        this.hotel = hotel;
    }

}
