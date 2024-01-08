package com.example.demo.Models;

import com.example.demo.Models.Enums.RoomCategory;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "room")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Room extends BaseEntity{
    @Column
    private Integer roomNumber;

    @Column
    @Enumerated
    private RoomCategory roomCategory;

    @Column
    private Integer numberOfBeds;

    @Column
    private boolean occupied;

    @Column
    private Integer price;

    @JsonIgnore
    @ManyToMany(mappedBy = "bookedRooms")
    private Set<Booking> bookedRooms = new HashSet<>();

    @ManyToOne
    @JoinColumn
    private Hotel hotel;
}
