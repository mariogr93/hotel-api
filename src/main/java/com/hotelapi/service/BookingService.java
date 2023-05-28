package com.hotelapi.service;

import com.hotelapi.model.entity.BookingEntity;
import com.hotelapi.model.request.BookingDTO;
import com.hotelapi.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService {


    private final BookingRepository bookingRepository;

    public BookingEntity createBooking(BookingDTO bookingDTO) {
        BookingEntity booking = bookingDTO.createBookingEntity();
        return this.bookingRepository.save(booking);
    }
    public List<BookingEntity> getAllBookings() {

        return this.bookingRepository.findAll();
    }

    public List<BookingEntity> getAllBookingsByClientId(Integer id) {


       return this.bookingRepository.findAllByClientId(id);
    }
}
