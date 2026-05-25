package com.marriagehall.booking_service.service;

import com.marriagehall.booking_service.dto.BookingDetailResponse;
import com.marriagehall.booking_service.dto.BookingRequest;
import com.marriagehall.booking_service.dto.HallResponse;
import com.marriagehall.booking_service.entity.Booking;
import com.marriagehall.booking_service.enums.BookingStatus;
import com.marriagehall.booking_service.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;
    private final WebClient webClient;

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

    public HallResponse getHallDetails(UUID hallId ){
        return webClient
                .get()
                .uri("http://localhost:8082/api/halls/"+ hallId )
                .retrieve()
                .bodyToMono(HallResponse.class)
                .block();

    }

    public BookingDetailResponse getBookingDetails(UUID bookingId){
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
        HallResponse hall = getHallDetails(booking.getHallId());
        return new BookingDetailResponse(
                booking,
                hall
        );
    }

}
