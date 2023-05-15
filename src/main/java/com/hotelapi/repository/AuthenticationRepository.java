package com.hotelapi.repository;

import com.hotelapi.config.security.UserDetailsImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface AuthenticationRepository extends JpaRepository<UserDetailsImpl, Integer> {

    Boolean existsByEmail(String email);
    Optional<UserDetailsImpl> findByEmail(String email);
}
