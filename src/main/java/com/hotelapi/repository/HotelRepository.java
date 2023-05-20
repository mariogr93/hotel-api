package com.hotelapi.repository;

import com.hotelapi.model.entity.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<HotelEntity, Integer> {
}
