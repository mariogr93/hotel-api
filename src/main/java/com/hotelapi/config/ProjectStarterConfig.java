package com.hotelapi.config;

import com.hotelapi.model.entity.HotelEntity;
import com.hotelapi.model.entity.RoomEntity;
import com.hotelapi.model.entity.RoomTypeEntity;
import com.hotelapi.repository.HotelRepository;
import com.hotelapi.repository.RoomRepository;
import com.hotelapi.repository.RoomTypeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

import static com.hotelapi.model.enums.RoomType.*;

@Configuration
public class ProjectStarterConfig {

    @Bean
    CommandLineRunner commandLineRunner(HotelRepository hotelRepository, RoomTypeRepository roomTypeRepository, RoomRepository roomRepository) {
        return args -> {
            HotelEntity hotel = new HotelEntity("hotel 5 stars", "address", "samana city", "Dom Rep");
            HotelEntity savedHotel = hotelRepository.save(hotel);
            System.out.println("savedHotel.toString()" +savedHotel.toString());

            RoomTypeEntity roomTypeSingle = new RoomTypeEntity(SINGLE_BED, 30, 2);
            RoomTypeEntity roomTypeDouble = new RoomTypeEntity(DOUBLE_BED, 30, 2);
            RoomTypeEntity roomTypeTriple = new RoomTypeEntity(TRIPLE_BED, 30, 2);
            List<RoomTypeEntity> listOfRoomTypes = roomTypeRepository.saveAll(List.of(roomTypeSingle, roomTypeDouble, roomTypeTriple));
            listOfRoomTypes.forEach((roomT) -> System.out.println(roomT.toString()));

            RoomEntity roomSingleOne = new RoomEntity(11, "a-single-1", false, hotel, roomTypeSingle);
            RoomEntity roomSingleTwo = new RoomEntity(12, "a-single-2", false, hotel, roomTypeSingle);
            RoomEntity roomDoubleOne = new RoomEntity(21, "b-double-1", false, hotel, roomTypeDouble);
            RoomEntity roomDoubleTwo = new RoomEntity(22, "b-double-2", false, hotel, roomTypeDouble);
            RoomEntity roomTripleOne = new RoomEntity(31, "c-triple-1", false, hotel, roomTypeTriple);
            RoomEntity roomTripleTwo = new RoomEntity(32, "c-triple-2", false, hotel, roomTypeTriple);



            List<RoomEntity> listOfRoomEntity = roomRepository.saveAll(List.of(roomSingleOne, roomSingleTwo, roomDoubleOne, roomDoubleTwo, roomTripleOne, roomTripleTwo));

            listOfRoomEntity.forEach((roomE) -> System.out.println(roomE.toString()));
        };
    }
}


