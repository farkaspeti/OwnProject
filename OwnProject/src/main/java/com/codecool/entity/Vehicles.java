package com.codecool.entity;

import com.codecool.enums.Craft;
import com.codecool.enums.Fuel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "Vehicles")
@NamedQueries({
        @NamedQuery(name = "Vehicles.getVehiclesById", query = "SELECT v FROM Vehicles v WHERE v.id =:fId"),
        @NamedQuery(name = "Vehicles.getTrucks", query = "SELECT v FROM Vehicles v WHERE v.craftType = 'TRUCK'"),
        @NamedQuery(name = "Vehicles.getBus", query = "SELECT v FROM Vehicles v WHERE v.craftType = 'BUS'"),
        @NamedQuery(name = "Vehicles.getCar", query = "SELECT v FROM Vehicles v WHERE v.craftType = 'CAR'"),
        @NamedQuery(name = "Vehicles.getGas", query = "SELECT v FROM Vehicles v WHERE v.fuelType = 'GAS'"),
        @NamedQuery(name = "Vehicles.getDiesel", query = "SELECT v FROM Vehicles v WHERE v.fuelType = 'DIESEL'"),
        @NamedQuery(name = "Vehicles.getVehiclesByName", query = "SELECT v FROM Vehicles v WHERE v.name = :fname")
})
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
