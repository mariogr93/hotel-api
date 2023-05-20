package com.hotelapi.model.entity;

import com.hotelapi.config.security.UserDetailsImpl;
import com.hotelapi.model.enums.Gender;
import com.hotelapi.model.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Entity
@Table(name = "employee")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeEntity extends UserDetailsImpl { //implements UserDetails {

    @Id
    @SequenceGenerator(name = "employee_sequence", sequenceName = "employee_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_sequence")
    private Integer id;
//    private String firstName;
//    private String lastName;
//    private Integer phoneNumber;
//    private String email;
//    private String password;
    private Integer salary;
//    @Enumerated(EnumType.STRING)
//    private Gender gender;
//    @Enumerated(EnumType.STRING)
//    private Role role;
    @ManyToOne
    @JoinColumn(name = "hotel")
    private HotelEntity hotel;

    public EmployeeEntity(String firstName, String lastName, Integer phoneNumber, String email, String password, Gender gender, Role role, Integer id, Integer salary, HotelEntity hotel) {
        super(firstName, lastName, phoneNumber, email, password, gender, role);
        this.id = id;
        this.salary = salary;
        this.hotel = hotel;
    }

    public EmployeeEntity(String firstName, String lastName, Integer phoneNumber, String email, String password, Integer salary, Gender gender, Role role, HotelEntity hotel) {
        super(firstName, lastName, phoneNumber, email, password, gender, role);
        this.salary = salary;
        this.hotel = hotel;
    }

//    public EmployeeEntity(String firstName, String lastName, Integer phoneNumber, String email, String password, Integer salary, Gender gender, Role role, HotelEntity hotel) {
//        super(firstName, lastName, phoneNumber, email, password, gender, role);
//        this.salary = salary;
//        this.hotel = hotel;
//    }

    //    public EmployeeEntity(String firstName, String lastName, Integer phoneNumber, String email, String password, Integer salary, Gender gender, Role role, HotelEntity hotel) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.phoneNumber = phoneNumber;
//        this.email = email;
//        this.password = password;
//        this.salary = salary;
//        this.gender = gender;
//        this.role = role;
//        this.hotel = hotel;
//    }

//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return this.role.getAuthorities();
//    }
//
//    @Override
//    public String getUsername() { return this.email; }
//
//    @Override
//    public String getPassword() {
//        return this.password;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() { return true; }
//
//    @Override
//    public boolean isAccountNonLocked() { return true; }
//
//    @Override
//    public boolean isCredentialsNonExpired() { return true; }
//
//    @Override
//    public boolean isEnabled() { return true; }
}
