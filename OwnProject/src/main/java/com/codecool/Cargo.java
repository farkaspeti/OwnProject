package com.codecool;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cargo {
    private String cargoName;
    private int cargoSpace;

    public Cargo(String cargoName, int cargoSpace) {
        this.cargoName = cargoName;
        this.cargoSpace = cargoSpace;

    }
}
