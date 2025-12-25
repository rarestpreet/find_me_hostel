package com.project.hostel_finder.dto;

import lombok.Builder;

@Builder
public class UserResponseDto {
    private String id;
    private String name;
    private String email;
    private String password;
    private String phone_number;
}
