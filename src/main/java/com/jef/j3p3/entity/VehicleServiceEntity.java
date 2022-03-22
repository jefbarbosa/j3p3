package com.jef.j3p3.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class VehicleServiceEntity {
    private Long id;
    private LocalDate date;
    private Long kilometers;
    private String descriptions;

    public VehicleServiceEntity(LocalDate date, Long kilometers, String descriptions) {
        this.date = date;
        this.kilometers = kilometers;
        this.descriptions = descriptions;
    }
}
