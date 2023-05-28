package com.hotelapi.service;

import com.hotelapi.model.entity.BookingEntity;
import com.hotelapi.model.request.BookingDTO;
import com.hotelapi.model.response.BookingResponse;
import com.hotelapi.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookingService {


    private final BookingRepository bookingRepository;

    public BookingResponse createBooking(BookingDTO bookingDTO) {
        BookingEntity booking = this.bookingRepository.save(bookingDTO.createBookingEntity());

        return BookingResponse.builder()
                        .id(booking.getId())
                        .date(booking.getDate())
                        .arraivalDate(booking.getArraivalDate())
                        .departureDate(booking.getDepartureDate())
                        .numberOfAdults(booking.getNumberOfAdults())
                        .numberOfChildren(booking.getNumberOfChildren())
                        .clientId(booking.getClientEntity().getId())
                        .clientFirstName(booking.getClientEntity().getFirstName())
                        .clientLastName(booking.getClientEntity().getLastName())
                        .roomId(booking.getRoomEntity().getId())
                        .roomNumber(booking.getRoomEntity().getRoomNumber())
                        .hotelRoomCode(booking.getRoomEntity().getHotelRoomCode())
                        . roomType(booking.getRoomEntity().getRoomType().getRoomType())
                        .roomPrice(booking.getRoomEntity().getRoomType().getRoomPrice())
                        .roomCapacity(booking.getRoomEntity().getRoomType().getRoomCapacity())
                        .hotelId(booking.getHotel().getId())
                        .hotelName(booking.getHotel().getHotelName())
                        .build();

    }
    public List<BookingEntity> getAllBookings() {

        return this.bookingRepository.findAll();
    }

    public List<BookingResponse> getAllBookingsByClientId(Integer id) {

        List<BookingResponse> bookingList = this.bookingRepository.findAllByClientId(id)
                .stream().map(b -> BookingResponse.builder()
                        .id(b.getId())
                        .date(b.getDate())
                        .arraivalDate(b.getArraivalDate())
                        .departureDate(b.getDepartureDate())
                        .numberOfAdults(b.getNumberOfAdults())
                        .numberOfChildren(b.getNumberOfChildren())
                        .clientId(b.getClientEntity().getId())
                        .clientFirstName(b.getClientEntity().getFirstName())
                        .clientLastName(b.getClientEntity().getLastName())
                        .roomId(b.getRoomEntity().getId())
                        .roomNumber(b.getRoomEntity().getRoomNumber())
                        .hotelRoomCode(b.getRoomEntity().getHotelRoomCode())
                        . roomType(b.getRoomEntity().getRoomType().getRoomType())
                        .roomPrice(b.getRoomEntity().getRoomType().getRoomPrice())
                        .roomCapacity(b.getRoomEntity().getRoomType().getRoomCapacity())
                        .hotelId(b.getHotel().getId())
                        .hotelName(b.getHotel().getHotelName())
                        .build()).collect(Collectors.toList());

       return bookingList;
    }
}
