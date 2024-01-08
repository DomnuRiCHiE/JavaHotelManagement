package com.example.demo.Models;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "beverage")
public class Beverage extends Item{
    @Column
    protected Integer volume;

    @Column
    protected Integer alcoholPercentage;

    public Beverage(String name, Double price, String description, Integer volume, Integer alcoholPercentage) {
        super(name, price, description);
        this.volume = volume;
        this.alcoholPercentage = alcoholPercentage;
    }

    public Beverage copy() {
        return new Beverage(name, price, description, volume, alcoholPercentage);
    }
}
