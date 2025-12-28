package com.project.hostel_finder.controller;

import com.project.hostel_finder.model.Hostel;
import com.project.hostel_finder.service.HostelService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/hostel")
public class HostelController {

    private final HostelService hostelService;

    @GetMapping("/search")
    public ResponseEntity<?> searchHostel(@RequestParam String city) {
        List<Hostel> hostelList = hostelService.searchCityVise(city);
        if (hostelList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hostel found in " + city);
        }
        return ResponseEntity.status(HttpStatus.OK).body(hostelList);
    }

    @GetMapping("/")
    public ResponseEntity<?> showHostels(
            @RequestParam(required = false) String city,
            @RequestParam(required = false) Integer price
    ) {
        List<Hostel> hostelList;
        if (city == null && price == null) {
            hostelList = hostelService.getAllHostels();
        } else {
            hostelList = hostelService.getByFilters(city, price);
        }
        if (hostelList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hostel found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(hostelList);
    }

}
