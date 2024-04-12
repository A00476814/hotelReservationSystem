package com.mcda5550.hotelreservationsystem.core.persistence;

import com.mcda5550.hotelreservationsystem.core.models.domain.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {


}