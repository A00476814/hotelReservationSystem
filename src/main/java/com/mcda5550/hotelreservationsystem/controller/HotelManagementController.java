package com.mcda5550.hotelreservationsystem.controller;

import com.mcda5550.hotelreservationsystem.core.application.service.GetListOfHotelsApplicationService;
import com.mcda5550.hotelreservationsystem.core.models.domain.Booking;
import com.mcda5550.hotelreservationsystem.core.models.domain.Hotel;
import com.mcda5550.hotelreservationsystem.core.persistence.BookingRepository;
import com.mcda5550.hotelreservationsystem.core.persistence.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.format.annotation.DateTimeFormat;


import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/mcda5550/hotels")
public class HotelManagementController {

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private GetListOfHotelsApplicationService getListOfHotelsApplicationService;

    // This endpoint get the list of available hotels for the requested checking and checkout date and the numberOfRooms required
    @GetMapping("/getAvailableHotels")
    public List<Hotel> getAvailableHotels(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkIn,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkOut,
            @RequestParam int numberOfRoomsRequired) {
        return getListOfHotelsApplicationService.getAvailableHotels(checkIn, checkOut, numberOfRoomsRequired);
    }

    // This endpoint adds a new hotel to the DB
    @PostMapping("/addHotel")
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
        try {
            Hotel _hotel = hotelRepository.save(new Hotel(hotel.getName(), hotel.getLocation(), hotel.getRating(), hotel.getNoOfRooms()));
            return new ResponseEntity<>(_hotel, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // This endpoint creates a new booking in system
    @PostMapping("/createBooking")
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {
        try {
            Booking newBooking = bookingRepository.save(booking);
            return new ResponseEntity<>(newBooking, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}