package com.example.demo.Models;

import jakarta.persistence.*;
import lombok.*;
import java.util.Objects;

@Entity
@Table(name = "item")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
public class Item extends BaseEntity {

    @Column
    protected String name;

    @Column
    protected Double price;

    @Column
    protected String description;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "menuID", referencedColumnName = "id")
    private Menu menu;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "restaurantOrderID", referencedColumnName = "id")
    private RestaurantOrder restaurantOrder;

    //public Item copy() {
    //    return new Item(name, price, description);
    //}

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(name, item.name);
    }
}
