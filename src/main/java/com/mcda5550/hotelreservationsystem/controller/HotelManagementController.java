package com.mcda5550.hotelreservationsystem.controller;

import com.mcda5550.hotelreservationsystem.core.models.domain.Hotel;
import com.mcda5550.hotelreservationsystem.core.persistence.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mcda5550/hotels")
public class HotelManagementController {

    @Autowired
    private HotelRepository hotelRepository;

    @GetMapping("/getAllHotels")
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @PostMapping("/addHotel")
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
        try {
            Hotel _hotel = hotelRepository.save(new Hotel(hotel.getName(), hotel.getLocation(), hotel.getRating(), hotel.getNoOfRooms()));
            return new ResponseEntity<>(_hotel, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}