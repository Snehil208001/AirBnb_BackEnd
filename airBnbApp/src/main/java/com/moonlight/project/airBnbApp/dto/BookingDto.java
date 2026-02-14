package com.moonlight.project.airBnbApp.dto;

import com.moonlight.project.airBnbApp.entity.enums.BookingStatus;
import lombok.Data; // <--- This is crucial for JSON serialization
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class BookingDto {
    private Long id;
    private HotelDto hotel;
    private RoomDto room;
    private UserDto user; // Changed from User to UserDto
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private Integer roomsCount;
    private BigDecimal amount;
    private BookingStatus bookingStatus;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}