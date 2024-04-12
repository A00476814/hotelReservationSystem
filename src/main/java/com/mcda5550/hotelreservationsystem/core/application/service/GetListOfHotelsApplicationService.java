package com.mcda5550.hotelreservationsystem.core.application.service;

import com.mcda5550.hotelreservationsystem.core.models.domain.Hotel;
import com.mcda5550.hotelreservationsystem.core.persistence.BookingRepository;
import com.mcda5550.hotelreservationsystem.core.persistence.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetListOfHotelsApplicationService {
    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private BookingRepository bookingRepository;

    // This method filters the hotels on the basis of availability by checking the existing bookings in the system and return only the available hotels.
    public List<Hotel> getAvailableHotels(LocalDate checkIn, LocalDate checkOut, int numberOfRoomsRequired) {
        List<Hotel> allHotels = hotelRepository.findAll();
        return allHotels.stream()
                .filter(hotel -> {
                    int bookedRooms = bookingRepository.countBookedRooms(hotel.getId(), checkIn, checkOut);
                    return (hotel.getNoOfRooms() - bookedRooms) >= numberOfRoomsRequired;
                })
                .collect(Collectors.toList());
    }
}
