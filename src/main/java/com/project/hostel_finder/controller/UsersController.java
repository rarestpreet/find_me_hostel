package com.project.hostel_finder.controller;

import com.project.hostel_finder.dto.UserRequestDto;
import com.project.hostel_finder.mapper.UsersMapper;
import com.project.hostel_finder.model.Users;
import com.project.hostel_finder.repository.UsersRepo;
import com.project.hostel_finder.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UsersController {

    private final UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping
    public ResponseEntity<?> test() {
        return ResponseEntity.status(HttpStatus.OK).body("test");
    }

    @GetMapping("${id}")
    public ResponseEntity<?> getProfile(@RequestParam long id) {
        try {
            Users user = usersService.findUser(id);
            return ResponseEntity.status(HttpStatus.OK).body(new UsersMapper().toDto(user));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> login(@RequestBody UserRequestDto dto) {
        try{
            Users user = usersService.validateUser(dto);
            return ResponseEntity.status(HttpStatus.OK).body(new UsersMapper().toDto(user));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> register(@RequestBody UserRequestDto dto) {
        Users newUser = usersService.createUser(dto);
        if(newUser == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error creating user");
        }
        return ResponseEntity.status(HttpStatus.OK).body(new UsersMapper().toDto(newUser));
    }

    @DeleteMapping("/${id}")
    public ResponseEntity<?> deleteAccount(@RequestParam long id) {
        usersService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("${id}")
    public ResponseEntity<?> updateProfile(@RequestParam long id, @RequestBody UserRequestDto userDto) {
        Users user = usersService.updateDetail(id, userDto);
        return ResponseEntity.status(HttpStatus.OK).body(new UsersMapper().toDto(user));
    }
}
