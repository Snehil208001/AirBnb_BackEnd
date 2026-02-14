package com.moonlight.project.airBnbApp.dto;

import com.moonlight.project.airBnbApp.entity.User;
import com.moonlight.project.airBnbApp.entity.enums.Gender;
import jakarta.persistence.*;
import lombok.Data;

@Data
public class GuestDto {

    private Long id;
    private User user;
    private String name;
    private Gender gender;
    private Integer age;
}
