package com.project.hostel_finder.mapper;

import com.project.hostel_finder.dto.UserRequestDto;
import com.project.hostel_finder.dto.UserResponseDto;
import com.project.hostel_finder.model.Users;

public class UsersMapper {

    public Users toModel(UserRequestDto dto) {
        return Users.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .phone_number(dto.getPhone_number())
                .build();
    }

    public UserResponseDto toDto(Users users) {
        return UserResponseDto.builder()
                .id(String.valueOf(users.getId()))
                .name(users.getName())
                .email(users.getEmail())
                .password(users.getPassword())
                .phone_number(users.getPhone_number())
                .build();
    }
}
