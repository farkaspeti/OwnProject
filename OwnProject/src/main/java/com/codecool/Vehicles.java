package com.codecool;

import com.codecool.enums.Craft;
import com.codecool.enums.Fuel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Vehicles {

    private String name;
    private int consumption;
    private Fuel fuelType;
    private int space;
    private Craft craftType;
   
    public Vehicles(String name,int consumption,Fuel fuelType,int space,Craft craftType) {
        this.name = name;
        this.consumption = consumption;
        this.fuelType = fuelType;
        this.space = space;
        this.craftType = craftType;

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
