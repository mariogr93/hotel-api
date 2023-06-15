package com.hotelapi.service;

import com.hotelapi.model.entity.BillingEntity;
import com.hotelapi.model.entity.BookingEntity;
import com.hotelapi.model.request.BillingRequestDTO;
import com.hotelapi.model.response.BillingPaymentResponse;
import com.hotelapi.repository.BillingRepository;
import com.hotelapi.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class BillingService {

    private final BookingRepository bookingRepository;
    private final BillingRepository billingRepository;

    public BillingPaymentResponse generateBill(BillingRequestDTO bill) {

        BookingEntity booking = this.bookingRepository.findById(bill.getBooking().getId()).get();

        BillingEntity billingEntity = new BillingEntity(
                booking.getRoomEntity().getRoomType().getRoomPrice(),
                bill.getRestaurantCharge(),
                bill.getBarCharge(),
                LocalDateTime.now(),
                bill.getPaymentMethod(),
                booking.getArraivalDate(),
                booking.getDepartureDate(),
                booking.getClientEntity(),
                booking
        );
        BillingEntity savedBill = this.billingRepository.save(billingEntity);
        return  BillingPaymentResponse.builder()
                .id(savedBill.getId())
                .roomCharge(savedBill.getRoomCharge())
                .restaurantCharge(savedBill.getRestaurantCharge())
                .barCharge(savedBill.getBarCharge())
                .paymentDate(savedBill.getPaymentDate())
                .arrivalDate(savedBill.getArrivalDate())
                .departureDate(savedBill.getDepartureDate())
                .paymentMethod(savedBill.getPaymentMethod())
                .clientId(savedBill.getBooking().getClientEntity().getId())
                .clientFirstName(savedBill.getBooking().getClientEntity().getFirstName())
                .clientLastName(savedBill.getBooking().getClientEntity().getLastName())
                .roomId(savedBill.getBooking().getRoomEntity().getId())
                .roomNumber(savedBill.getBooking().getRoomEntity().getRoomNumber())
                .hotelRoomCode(savedBill.getBooking().getRoomEntity().getHotelRoomCode())
                .build();

    }
}
