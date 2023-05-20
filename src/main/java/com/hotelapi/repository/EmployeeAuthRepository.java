package com.hotelapi.repository;

import com.hotelapi.config.security.UserDetailsImpl;
import com.hotelapi.model.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeAuthRepository extends JpaRepository<EmployeeEntity, Integer> {

    Boolean existsByEmail(String email);
    Optional<EmployeeEntity> findByEmail(String email);
}
