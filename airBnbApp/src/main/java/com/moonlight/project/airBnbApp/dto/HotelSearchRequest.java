package com.moonlight.project.airBnbApp.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class HotelSearchRequest {
    private String city;
    private LocalDate checkInDate;
    private  LocalDate endDate;
    private Integer roomsCount;

    private Integer page=0;
    private Integer size=10;
}
