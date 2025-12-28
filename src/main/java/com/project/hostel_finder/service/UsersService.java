package com.project.hostel_finder.service;

import com.project.hostel_finder.dto.UserRequestDto;
import com.project.hostel_finder.exception.UserNotFoundException;
import com.project.hostel_finder.mapper.UsersMapper;
import com.project.hostel_finder.model.Users;
import com.project.hostel_finder.repository.UsersRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UsersService {

    private final UsersRepo usersRepo;


    public Users findUser(long id) {
        return usersRepo.findById(id).orElseThrow(
                () -> new UserNotFoundException("Error fetching user details")
        );
    }

    public Users validateUser(UserRequestDto dto) {
        return usersRepo.findByPhone_number(dto.getPhone_number()).orElseThrow(
                () -> new UserNotFoundException("Error fetching user details")
        );
    }

    public Users createUser(UserRequestDto userDto) {
        return usersRepo.save(new UsersMapper().toModel(userDto));
    }

    public void deleteUser(long id) {
        usersRepo.deleteById(id);
    }

    public Users updateDetail(long userid, UserRequestDto userDto) {
        Users oldUser = usersRepo.findById(userid).orElseThrow(
                () -> new UserNotFoundException("Error fetching user details")
        );
        oldUser.setName(userDto.getName());
        oldUser.setEmail(userDto.getEmail());
        oldUser.setPassword(userDto.getPassword());
        oldUser.setPhone_number(userDto.getPhone_number());
        return usersRepo.save(oldUser);
    }
}
