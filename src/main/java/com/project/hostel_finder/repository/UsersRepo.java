package com.project.hostel_finder.repository;

import com.project.hostel_finder.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepo extends JpaRepository<Users, Long> {
    Optional<Users> findByPhone_number(String phoneNumber);
}
