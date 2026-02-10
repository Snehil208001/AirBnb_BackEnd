package com.moonlight.project.airBnbApp.dto;

import com.moonlight.project.airBnbApp.entity.HotelContactInfo;
import com.moonlight.project.airBnbApp.entity.Room;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CurrentTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class HotelDto {
    private Long id;
    private String name;
    private String city;
    private String[] photos;
    private String[] amenities;
    private HotelContactInfo contactInfo;
    private Boolean active;
}
