package com.codecool;

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

    public String getName(){
        return this.name;
    }

    public int getConsumpton(){
        return this.consumption;
    }

    public Fuel getFuelType(){
        return this.fuelType;
    }

    public int getSpace() { return this.space; }

    public Craft getCraftType() { return this.craftType; }

    public void setName(String name) {
        this.name = name;
    }

    public void setConsumption(int consumption) {
        this.consumption = consumption;
    }

    public void setFuelType(Fuel fuelType) {
        this.fuelType = fuelType;
    }

    public void setSpace(int space) {
        this.space = space;
    }

    public void setCraftType(Craft craftType) {
        this.craftType = craftType;
    }
}
