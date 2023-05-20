package com.hotelapi.config.security;

import com.hotelapi.model.entity.ClientEntity;
import com.hotelapi.model.entity.EmployeeEntity;
import com.hotelapi.repository.AuthenticationRepository;
import com.hotelapi.repository.ClientAuthRepository;
import com.hotelapi.repository.EmployeeAuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    //private final AuthenticationRepository authService;
    private final EmployeeAuthRepository employeeAuthRepository;
    private final ClientAuthRepository clientAuthRepository;

    @Override
    public UserDetailsImpl loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("UserDetailsImpl loadUserByUsername() username: ---------------------" + username);

        String userType = username.split(",")[1];
        String newUsername = username.split(",")[0];

        if(userType.equals("CLIENT")){
            return this.clientAuthRepository.findByEmail(newUsername)
                    .orElseThrow(() -> new UsernameNotFoundException("Username Not Found Exception"));
        }

        return this.employeeAuthRepository.findByEmail(newUsername)
                .orElseThrow(() -> new UsernameNotFoundException("Username Not Found Exception"));
    }

    public EmployeeEntity loadEmployeeByUsername(String username) throws UsernameNotFoundException {
        return this.employeeAuthRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("Username Not Found Exception"));
    }

    public ClientEntity loadClientByUsername(String username) throws UsernameNotFoundException {
        return this.clientAuthRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("Username Not Found Exception"));
    }

}
