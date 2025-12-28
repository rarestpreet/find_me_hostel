package com.project.hostel_finder.service;

import com.project.hostel_finder.repository.CityRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HomePageService {

    private final CityRepo cityRepo;

    public List<String> citySuggestions(String keyword) {
        return cityRepo.suggestions(keyword);
    }
}
