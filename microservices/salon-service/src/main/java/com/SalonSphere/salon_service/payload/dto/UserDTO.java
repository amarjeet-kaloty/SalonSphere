package com.SalonSphere.salon_service.payload.dto;

import lombok.Data;

@Data
public class UserDTO {

    private Long id;

    private String fullName;

    private String email;
}
