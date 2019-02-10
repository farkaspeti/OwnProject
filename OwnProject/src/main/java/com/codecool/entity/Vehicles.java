package com.codecool.entity;

import com.codecool.enums.Craft;
import com.codecool.enums.Fuel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "Vehicles")
public class Vehicles {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int consumption;
    private Fuel fuelType;
    private int space;
    private Craft craftType;
   
    public Vehicles(String name, int consumption, Fuel fuelType, int space, Craft craftType) {
        this.name = name;
        this.consumption = consumption;
        this.fuelType = fuelType;
        this.space = space;
        this.craftType = craftType;

    }

    public Vehicles() {
    }

    @Override
    public String toString() {
        return
            name +"," + consumption +
            "," + fuelType +
            "," + space +
            "," + craftType;
    }
}
