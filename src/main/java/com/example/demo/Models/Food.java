package com.example.demo.Models;

import com.example.demo.Models.Enums.FoodType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.*;

/**
 * Entity class representing food or meals for a restaurant
 */

@Entity
@Table(name = "food")
@Getter
@Setter
@NoArgsConstructor
public class Food extends Item {
    @Column
    protected Integer quantity;

    @Column
    protected Integer spiceLevel;

    @Column
    @Enumerated
    protected FoodType foodType = FoodType.none;

    public Food(String name, Double price, String description, Integer quantity, Integer spiceLevel, FoodType foodType) {
        super(name, price, description);
        this.quantity = quantity;
        this.spiceLevel = spiceLevel;
        this.foodType = foodType;
    }

    public Food copy() {
        return new Food(name, price, description, quantity, spiceLevel, foodType);
    }
}
