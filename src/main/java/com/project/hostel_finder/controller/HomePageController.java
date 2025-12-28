package com.project.hostel_finder.controller;

import com.project.hostel_finder.service.HomePageService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/home")
@AllArgsConstructor
public class HomePageController {

    private final HomePageService homePageService;


    @GetMapping("/search")
    public ResponseEntity<?> searchSuggestion(@RequestParam String keyword) {
        List<String> similarSearches = homePageService.citySuggestions(keyword);
        if(similarSearches.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No city suggestions found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(similarSearches);
    }
}
