package com.marriagehall.booking_service.controller;

import com.marriagehall.booking_service.dto.BookingRequest;
import com.marriagehall.booking_service.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/booking")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    public ResponseEntity<?> create(@RequestBody BookingRequest bookingReuest){
        return ResponseEntity.ok(bookingService.createBooking(bookingReuest));
    }

}
