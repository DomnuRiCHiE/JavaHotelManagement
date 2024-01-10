package com.example.demo.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;


import java.util.HashSet;
import java.util.Set;

/**
 * Entity class for representing clients in a hotel
 */

@Entity
@Table(name = "client")
@NoArgsConstructor
@Getter
@Setter
public class Client extends Person{
    @Column
    protected String address;

//    @JsonIgnore
//    @OneToMany(mappedBy = "client")
//    private Set<Booking> bookings = new HashSet<>();
//
//    @JsonIgnore
//    @OneToMany(mappedBy = "client")
//    private Set<RestaurantOrder> restaurantOrders = new HashSet<>();
//
//    @JsonIgnore
//    @ManyToMany(mappedBy = "hotelClients")
//    private Set<Hotel> hotelClients = new HashSet<>();
//
    public Client(String name, String email, String phoneNumber, String address) {
        super(name, email, phoneNumber);
        this.address = address;
    }

    public Client copy() {
        return new Client(name, email, phoneNumber, address);
    }
}
