package com.marriagehall.booking_service.controller;

import com.marriagehall.booking_service.dto.BookingRequest;
import com.marriagehall.booking_service.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/booking")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody BookingRequest bookingReuest){
        return ResponseEntity.ok(bookingService.createBooking(bookingReuest));
    }

    @GetMapping("/{bookingId}")
    public ResponseEntity<?> getBooking(@PathVariable UUID bookingId){
       return  ResponseEntity.ok(bookingService.getBookingDetails(bookingId));
    }

}
