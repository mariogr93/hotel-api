package com.hotelapi.service;

import com.hotelapi.config.security.jwt.JwtService;
import com.hotelapi.model.entity.BookingEntity;
import com.hotelapi.model.entity.ClientEntity;
import com.hotelapi.model.entity.EmployeeEntity;
import com.hotelapi.model.enums.RoomType;
import com.hotelapi.model.request.ClientRegisterDTO;
import com.hotelapi.model.request.EmployeeRegisterDTO;
import com.hotelapi.model.request.UserLoginDTO;
import com.hotelapi.model.response.*;
import com.hotelapi.repository.BookingRepository;
import com.hotelapi.repository.ClientAuthRepository;
import com.hotelapi.repository.EmployeeAuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final ClientAuthRepository clientAuthRepository;
    private final EmployeeAuthRepository employeeAuthRepository;
    private final BookingRepository bookingRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public EmployeeRegisterResponse registerEmployee(EmployeeRegisterDTO employeeRegisterDTO) {
        if (this.employeeAuthRepository.existsByEmail(employeeRegisterDTO.getEmail())) {
            throw new IllegalStateException("Email already registered");
        }

        EmployeeEntity newEmployee = employeeRegisterDTO.createUserEntity();
        newEmployee.setPassword(this.passwordEncoder.encode(employeeRegisterDTO.getPassword()));
        EmployeeEntity registeredEmployee = this.employeeAuthRepository.save(newEmployee);
        return EmployeeRegisterResponse.builder()
                .id(registeredEmployee.getId())
                .firstName(registeredEmployee.getFirstName())
                .lastName(registeredEmployee.getLastName())
                .email(registeredEmployee.getEmail())
                .role(registeredEmployee.getRole())
                .gender(registeredEmployee.getGender())
                .phoneNumber(registeredEmployee.getPhoneNumber())
                .salary(registeredEmployee.getSalary())
                .hotel(registeredEmployee.getHotel())
                .build();

    }

    public EmployeeLoginResponse authenticateEmployee(UserLoginDTO userLoginDTO) {
        String newUsername =  userLoginDTO.getEmail() + ":EMPLOYEE";
        Authentication authentication = this.authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(newUsername, userLoginDTO.getPassword()));

        EmployeeEntity user = this.employeeAuthRepository.findByEmail(userLoginDTO.getEmail()).get();
        String token = this.jwtService.generateToken(user);
        return EmployeeLoginResponse.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .token(token)
                .role(user.getRole())
                .gender(user.getGender())
                .phoneNumber(user.getPhoneNumber())
                .salary(user.getSalary())
                .hotel(user.getHotel())
                .build();
    }

    public ClientRegisterResponse registerClient(ClientRegisterDTO clientRegisterDTO) {

        if (this.clientAuthRepository.existsByEmail(clientRegisterDTO.getEmail())) {
            throw new IllegalStateException("Email already registered");
        }

        ClientEntity newUser = clientRegisterDTO.createUserEntity();
        newUser.setPassword(this.passwordEncoder.encode(clientRegisterDTO.getPassword()));
        ClientEntity registeredUser = this.clientAuthRepository.save(newUser);
        registeredUser.setPassword("");
        return ClientRegisterResponse.builder()
                .id(registeredUser.getId())
                .firstName(registeredUser.getFirstName())
                .lastName(registeredUser.getLastName())
                .email(registeredUser.getEmail())
                .phoneNumber(registeredUser.getPhoneNumber())
                .role(registeredUser.getRole())
                .gender(registeredUser.getGender())
                .passportNumber(registeredUser.getPassportNumber())
                .build();
    }

    public ClientLoginResponse authenticateClient(UserLoginDTO userLoginDTO) {
        String newUsername =  userLoginDTO.getEmail() + ":CLIENT";
        Authentication authentication = this.authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(newUsername, userLoginDTO.getPassword()));

        ClientEntity user = this.clientAuthRepository.findByEmail(userLoginDTO.getEmail()).get();
        String token = this.jwtService.generateToken(user);

        List<BookingResponse> bookingList = this.bookingRepository.findAllByClientId(user.getId())
                .stream().map(b -> BookingResponse.builder()
                        .id(b.getId())
                        .date(b.getDate())
                        .arraivalDate(b.getArraivalDate())
                        .departureDate(b.getDepartureDate())
                        .numberOfAdults(b.getNumberOfAdults())
                        .numberOfChildren(b.getNumberOfChildren())
                        .clientId(b.getClientEntity().getId())
                        .clientFirstName(b.getClientEntity().getFirstName())
                        .clientLastName(b.getClientEntity().getLastName())
                        .roomId(b.getRoomEntity().getId())
                        .roomNumber(b.getRoomEntity().getRoomNumber())
                        .hotelRoomCode(b.getRoomEntity().getHotelRoomCode())
                        . roomType(b.getRoomEntity().getRoomType().getRoomType())
                        .roomPrice(b.getRoomEntity().getRoomType().getRoomPrice())
                        .roomCapacity(b.getRoomEntity().getRoomType().getRoomCapacity())
                        .hotelId(b.getHotel().getId())
                        .hotelName(b.getHotel().getHotelName())
                        .build()).collect(Collectors.toList());

        return ClientLoginResponse.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .role(user.getRole())
                .gender(user.getGender())
                .passportNumber(user.getPassportNumber())
                .booking(bookingList)
                .token(token)
                .build();
    }

}
