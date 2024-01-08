package com.example.demo.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "hotel")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Hotel extends BaseEntity{
    @Column
    private String name;
    @Column
    private String restaurant;

    @JsonIgnore
    @OneToMany(mappedBy = "hotelBooking")
    private Set<Booking> bookings = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "hotelRooms")
    private Set<Room> rooms = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "hotelClients",
            joinColumns = @JoinColumn(name = "hotelID"),
            inverseJoinColumns = @JoinColumn(name = "clientID")
    )
    private Set<Client> clients = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "hotelEmployees",
            joinColumns = @JoinColumn(name = "hotelID"),
            inverseJoinColumns = @JoinColumn(name = "employeeID")
    )
    private Set<Employee> employees = new HashSet<>();
}
