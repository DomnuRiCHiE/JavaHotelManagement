package com.example.demo.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "menu")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Menu extends BaseEntity{
    @Column
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "menu")
    private Set<Item> items = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "restaurantMenus",
            joinColumns = @JoinColumn(name = "menuID"),
            inverseJoinColumns = @JoinColumn(name = "restaurantID")
    )
    private Set<Restaurant> restaurantsMenus = new HashSet<>();
}
