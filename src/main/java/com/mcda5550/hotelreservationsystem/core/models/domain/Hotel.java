package com.mcda5550.hotelreservationsystem.core.models.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "hotels", uniqueConstraints = {@UniqueConstraint(columnNames = {"name"}, name = "uniqueHotelNameConstraint")})
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Hotel {
    // This model save information about a hotel in the DB
    // The Param defined for a Hotel are its Id(Primary Key), name, location, noOfRooms and  rating

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private Integer noOfRooms;

    private Double rating;


    public Hotel(String name, String location, Double rating, Integer noOfRooms) {
        this.name = name;
        this.location = location;
        this.rating = rating;
        this.noOfRooms = noOfRooms;
    }
}
