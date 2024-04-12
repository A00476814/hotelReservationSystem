package com.mcda5550.hotelreservationsystem.core.persistence;

import com.mcda5550.hotelreservationsystem.core.models.domain.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface BookingRepository extends JpaRepository<Booking, String> {

    // The custom method queries the db for count of booked rooms within a given range of dates.
    @Query("SELECT COALESCE(SUM(b.numberOfRooms), 0) FROM Booking b WHERE b.hotel.id = :hotelId AND b.checkIn < :checkOut AND b.checkOut > :checkIn")
    int countBookedRooms(@Param("hotelId") Long hotelId, @Param("checkIn") LocalDate checkIn, @Param("checkOut") LocalDate checkOut);

}
