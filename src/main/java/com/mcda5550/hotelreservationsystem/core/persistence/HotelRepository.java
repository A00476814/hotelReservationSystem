package com.mcda5550.hotelreservationsystem.core.persistence;

import com.mcda5550.hotelreservationsystem.core.models.domain.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
}