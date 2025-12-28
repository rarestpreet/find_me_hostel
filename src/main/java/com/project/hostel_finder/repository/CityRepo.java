package com.project.hostel_finder.repository;

import com.project.hostel_finder.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepo extends JpaRepository<City, Long> {
    City findByName(String name);

    @Query(value = "SELECT name FROM city WHERE LOWER(name) LIKE LOWER(CONCAT('%', :keyword, '%'))", nativeQuery = true)
    List<String> suggestions(@Param("keyword") String keyword);
}
