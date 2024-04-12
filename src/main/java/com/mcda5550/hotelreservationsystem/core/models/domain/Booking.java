package com.mcda5550.hotelreservationsystem.core.models.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

@Entity
@Table(name = "bookings")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Booking {


    // This model defines a booking in db
    // Model params includes bookingId(Primary Key), hotel(Hotel for which the booking is being made)
    // checkin, checkout, email, numberOfRooms and guestList

    @Id
    private String bookingId;

    @ManyToOne
    @JoinColumn(name = "hotel_id", nullable = false)
    private Hotel hotel;

    @Column(nullable = false)
    private LocalDate checkIn;

    @Column(nullable = false)
    private LocalDate checkOut;

    @Email
    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private int numberOfRooms;  // Add this line to track the number of rooms booked

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "booking_id")
    private List<Guest> guestsList;

    @Entity
    @Table(name = "guests")
    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    public static class Guest {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false)
        private String guestName;

        @Column(nullable = false)
        private String gender;
    }

    public static String generateBookingId() {
        Random random = new Random();
        long number = random.nextLong(9000000000L) + 1000000000L;
        return "Booking_" + number;
    }

    @PrePersist
    private void ensureId() {
        this.bookingId = generateBookingId();
    }
}
