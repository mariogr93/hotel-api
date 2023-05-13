package com.hotelapi.security;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDetailsRepository extends CrudRepository<UserDetailsImpl, Integer> {

    Optional<UserDetailsImpl> findByEmail(String email);
}
