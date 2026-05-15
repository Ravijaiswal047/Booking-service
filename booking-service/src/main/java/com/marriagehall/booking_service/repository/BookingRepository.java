package com.marriagehall.booking_service.repository;

import com.marriagehall.booking_service.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.UUID;

public interface BookingRepository extends JpaRepository<Booking, UUID> {
    boolean existsByBookingIdAndBookingDate(UUID hallId, LocalDate bookingDate);
}
