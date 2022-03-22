package com.jef.j3p3.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@NoArgsConstructor
public class VehicleEntity {
    private Long id;
    private String brand;
    private String model;
    private LocalDate manufacturingDate;
    private String numberOfKilometers;
    private String doors;
    private double price;
    private String currency;
    private String countOfOwners;

    public VehicleEntity(String brand, String model, LocalDate manufacturingDate, String numberOfKilometers, String doors,
                         double price, String currency, String countOfOwners) {
        this.brand = brand;
        this.model = model;
        this.manufacturingDate = manufacturingDate;
        this.numberOfKilometers = numberOfKilometers;
        this.doors = doors;
        this.price = price;
        this.currency = currency;
        this.countOfOwners = countOfOwners;
    }
}
