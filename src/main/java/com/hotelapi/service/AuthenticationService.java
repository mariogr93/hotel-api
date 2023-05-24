package com.hotelapi.service;

import com.hotelapi.config.security.jwt.JwtService;
import com.hotelapi.model.entity.ClientEntity;
import com.hotelapi.model.entity.EmployeeEntity;
import com.hotelapi.model.request.ClientRegisterDTO;
import com.hotelapi.model.request.EmployeeRegisterDTO;
import com.hotelapi.model.request.UserLoginDTO;
import com.hotelapi.model.response.UserLoginResponse;
import com.hotelapi.repository.ClientAuthRepository;
import com.hotelapi.repository.EmployeeAuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final ClientAuthRepository clientAuthRepository;
    private final EmployeeAuthRepository employeeAuthRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public EmployeeEntity registerEmployee(EmployeeRegisterDTO employeeRegisterDTO) {

        if (this.employeeAuthRepository.existsByEmail(employeeRegisterDTO.getEmail())) {
            throw new IllegalStateException("Email already registered");
        }

        EmployeeEntity newUser = employeeRegisterDTO.createUserEntity();
        newUser.setPassword(this.passwordEncoder.encode(employeeRegisterDTO.getPassword()));
        EmployeeEntity registeredUser = this.employeeAuthRepository.save(newUser);
        registeredUser.setPassword("");
        return registeredUser;
    }

    public UserLoginResponse authenticateEmployee(UserLoginDTO userLoginDTO) {
        String newUsername =  userLoginDTO.getEmail() + ":EMPLOYEE";
        Authentication authentication = this.authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(newUsername, userLoginDTO.getPassword()));

        EmployeeEntity user = this.employeeAuthRepository.findByEmail(userLoginDTO.getEmail()).get();
        String token = this.jwtService.generateToken(user);
        return UserLoginResponse.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .token(token)
                .role(user.getRole())
                .build();
    }

    public ClientEntity registerClient(ClientRegisterDTO clientRegisterDTO) {

        if (this.clientAuthRepository.existsByEmail(clientRegisterDTO.getEmail())) {
            throw new IllegalStateException("Email already registered");
        }

        ClientEntity newUser = clientRegisterDTO.createUserEntity();
        newUser.setPassword(this.passwordEncoder.encode(clientRegisterDTO.getPassword()));
        ClientEntity registeredUser = this.clientAuthRepository.save(newUser);
        registeredUser.setPassword("");
        return registeredUser;
    }

    public UserLoginResponse authenticateClient(UserLoginDTO userLoginDTO) {
        String newUsername =  userLoginDTO.getEmail() + ":CLIENT";
        Authentication authentication = this.authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(newUsername, userLoginDTO.getPassword()));

        ClientEntity user = this.clientAuthRepository.findByEmail(userLoginDTO.getEmail()).get();
        String token = this.jwtService.generateToken(user);
        return UserLoginResponse.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .token(token)
                .role(user.getRole())
                .build();
    }

}
