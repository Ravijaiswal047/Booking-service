package com.marriagehall.booking_service.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class BookingRequest {
    private UUID userId;
    private UUID hallId;
    private LocalDate bookingDate;

}
