package com.jef.j3p3.DTO;

import com.jef.j3p3.entity.VehicleServiceEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class VehicleServicesDTO {
    private LocalDate date;
    private Long kilometers;
    private String descriptions;

    public static VehicleServiceEntity DTOtoEntity(VehicleServicesDTO vSDTO) {
        return new VehicleServiceEntity(vSDTO.getDate(), vSDTO.getKilometers(), vSDTO.getDescriptions());
    }

    public static VehicleServicesDTO EntitytoDTO(VehicleServiceEntity vSEntity) {
        return new VehicleServicesDTO(vSEntity.getDate(), vSEntity.getKilometers(), vSEntity.getDescriptions());
    }
}
