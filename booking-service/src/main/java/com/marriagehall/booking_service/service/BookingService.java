package com.marriagehall.booking_service.service;

import com.marriagehall.booking_service.dto.BookingRequest;
import com.marriagehall.booking_service.entity.Booking;
import com.marriagehall.booking_service.enums.BookingStatus;
import com.marriagehall.booking_service.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;

    public Booking createBooking(BookingRequest bookingRequest) {
        if(bookingRepository.existsByBookingIdAndBookingDate(bookingRequest.getHallId(), bookingRequest.getBookingDate())){
            throw new RuntimeException("Hall already booked for this date");
        }

        Booking booking = new Booking();
        booking.setUserId(bookingRequest.getUserId());
        booking.setHallId(bookingRequest.getHallId());
        booking.setBookingDate(bookingRequest.getBookingDate());
        booking.setStatus(BookingStatus.PENDING); // Because Payment is not done yet
        return bookingRepository.save(booking);
    }
}
