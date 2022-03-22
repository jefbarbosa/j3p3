package com.jef.j3p3.DTO;

import com.jef.j3p3.entity.VehicleEntity;
import com.jef.j3p3.entity.VehicleServiceEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDTO {
    private String brand;
    private String model;
    private LocalDate manufacturingDate;
    private String numberOfKilometers;
    private String doors;
    private double price;
    private String currency;
    private List<VehicleServicesDTO> services = new ArrayList<>();
    private String countOfOwners;

    public VehicleEntity DTOtoEntity() {
        return new VehicleEntity(brand, model, manufacturingDate, numberOfKilometers,
                doors, price, currency, countOfOwners);
    }

    public VehicleDTO(String brand, String model, LocalDate manufacturingDate, String numberOfKilometers, String doors,
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



    public static VehicleDTO EntityToDTO(VehicleEntity vEntity) {
        return new VehicleDTO(vEntity.getBrand(), vEntity.getModel(), vEntity.getManufacturingDate(),
                vEntity.getNumberOfKilometers(), vEntity.getDoors(), vEntity.getPrice(), vEntity.getCurrency(),
                vEntity.getCountOfOwners());
    }

    public static VehicleDTO EntityToDTOServices(VehicleEntity vEntity, List<VehicleServicesDTO> vehicleServicesDTOList) {
        return new VehicleDTO(vEntity.getBrand(), vEntity.getModel(), vEntity.getManufacturingDate(),
                vEntity.getNumberOfKilometers(), vEntity.getDoors(), vEntity.getPrice(), vEntity.getCurrency(),
                vehicleServicesDTOList, vEntity.getCountOfOwners());
    }
}
