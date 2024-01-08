package com.example.demo.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "restaurant")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Restaurant extends BaseEntity{
    @Column
    private String name;

    //@OneToMany(cascade = CascadeType.ALL)
    //@JoinColumn(name = "restaurantID")
    //private Set<Menu> menus = new HashSet<>();

    //
    @JsonIgnore
    @ManyToMany(mappedBy = "restaurantMenus")
    private Set<Menu> restaurantMenus = new HashSet<>();
}
