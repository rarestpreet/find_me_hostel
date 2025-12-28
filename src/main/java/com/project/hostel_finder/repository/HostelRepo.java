package com.project.hostel_finder.repository;

import com.project.hostel_finder.model.City;
import com.project.hostel_finder.model.Hostel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HostelRepo extends JpaRepository<Hostel, Long> {
    List<Hostel> findByCity(City city);

    @Query(value = "SELECT * FROM hostel WHERE LOWER(city) LIKE LOWER(CONCAT('%', :city, '%')) AND " +
            "price <= :range", nativeQuery = true)
    List<Hostel> findHostelsByFilters(@Param("city") String city, @Param("range") int price);
}
