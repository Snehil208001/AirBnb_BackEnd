package com.moonlight.project.airBnbApp.dto;

import com.moonlight.project.airBnbApp.entity.enums.Role;
import lombok.Data;
import java.util.Set;

@Data
public class UserDto {
    private Long id;
    private String name;
    private String email;
    private Set<Role> roles;
}