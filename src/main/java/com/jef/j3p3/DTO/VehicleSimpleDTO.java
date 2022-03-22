package com.jef.j3p3.DTO;

import lombok.Data;


@Data
public class VehicleSimpleDTO {
    private String brand;
    private String model;
    private String manufacturingDate;
    private String numberOfKilometers;
    private String doors;
    private double price;
    private String currency;
    private String countOfOwners;
}
