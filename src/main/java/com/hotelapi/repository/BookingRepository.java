package com.hotelapi.repository;

import com.hotelapi.model.entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<BookingEntity, Integer> {

    @Query("""
    Select n from BookingEntity n inner join ClientEntity u on n.clientEntity.id = u.id where u.id = :clientId
    """)
    ArrayList<BookingEntity> findAllByClientId(Integer clientId);
}
