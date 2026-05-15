package com.marriagehall.booking_service.entity;

import com.marriagehall.booking_service.enums.BookingStatus;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
public class Booking {
    @Id
    @UuidGenerator
    @GeneratedValue
    private UUID id;
    private UUID userId;
    private UUID hallId;

    private LocalDate bookingDate;

    @Enumerated(EnumType.STRING)
    private BookingStatus status;
}
