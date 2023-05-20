package com.hotelapi.config;

import com.hotelapi.model.entity.HotelEntity;
import com.hotelapi.repository.HotelRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectStarterConfig {

    @Bean
    CommandLineRunner commandLineRunner(HotelRepository hotelRepository){
        return args -> {
            HotelEntity hotel = new HotelEntity("hotel 5 stars", "address", "samana city", "Dom Rep");
            hotelRepository.save(hotel);
        };
    }
}


