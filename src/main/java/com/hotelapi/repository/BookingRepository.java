package com.hotelapi.repository;

import com.hotelapi.model.entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<BookingEntity, Integer> {

    Optional<BookingEntity> findById(Integer bookingId);
    @Query("""
    Select b from BookingEntity b inner join ClientEntity c on b.clientEntity.id = c.id where c.id = :clientId
    """)
    ArrayList<BookingEntity> findAllByClientId(Integer clientId);
}
