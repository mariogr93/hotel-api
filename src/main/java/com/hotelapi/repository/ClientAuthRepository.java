package com.hotelapi.repository;

import com.hotelapi.model.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientAuthRepository extends JpaRepository<ClientEntity, Integer> {

    Boolean existsByEmail(String email);
    Optional<ClientEntity> findByEmail(String email);
}