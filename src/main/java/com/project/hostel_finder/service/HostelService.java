package com.project.hostel_finder.service;

import com.project.hostel_finder.model.Hostel;
import com.project.hostel_finder.repository.CityRepo;
import com.project.hostel_finder.repository.HostelRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HostelService {


    private final HostelRepo hostelRepo;
    private final CityRepo cityRepo;

    public List<Hostel> searchCityVise(String city) {
        return hostelRepo.findByCity(cityRepo.findByName(city));
    }

    public List<Hostel> getAllHostels() {
        return hostelRepo.findAll();
    }

    public List<Hostel> getByFilters(String city, int price) {
        return hostelRepo.findHostelsByFilters(city, price);
    }
}
