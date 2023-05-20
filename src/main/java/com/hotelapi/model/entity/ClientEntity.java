package com.hotelapi.model.entity;

import com.hotelapi.config.security.UserDetailsImpl;
import com.hotelapi.model.enums.Gender;
import com.hotelapi.model.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "client")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ClientEntity extends UserDetailsImpl {

    @Id
    @SequenceGenerator(
            name = "client_sequence",
            sequenceName = "client_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "client_sequence"
    )
    private Integer id;
//    private String firstName;
//    private String lastName;
//    private Integer phoneNumber;
//    private String email;
//    private String password;
    private String passportNumber;
//    @Enumerated(EnumType.STRING)
//    private Gender gender;
//    @Enumerated(EnumType.STRING)
//    private Role role;
    @ManyToOne
    @JoinColumn(name ="booking")
    private BookingEntity booking;

    public ClientEntity(String firstName, String lastName, Integer phoneNumber, String email, String password, Gender gender, Role role, Integer id, String passportNumber, BookingEntity booking) {
        super(firstName, lastName, phoneNumber, email, password, gender, role);
        this.id = id;
        this.passportNumber = passportNumber;
        this.booking = booking;
    }


}
