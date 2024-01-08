package com.example.demo.Models;

import com.example.demo.Models.Enums.RoomCategory;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "booking")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Booking extends BaseEntity{
    @Column
    @Enumerated
    private RoomCategory roomCategory;

    //@Column
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "clientID", referencedColumnName = "id")
    private Client client;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hotelID", referencedColumnName = "id")
    private Hotel hotel;

    @ManyToMany
    @JoinTable(
            name = "bookedRooms",
            joinColumns = @JoinColumn(name = "bookingID"),
            inverseJoinColumns = @JoinColumn(name = "roomID")
    )
    private Set<Room> bookedRooms = new HashSet<>();
}
