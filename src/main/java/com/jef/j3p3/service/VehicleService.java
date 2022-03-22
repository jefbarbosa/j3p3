package com.jef.j3p3.service;

import com.jef.j3p3.DTO.VehicleDTO;
import com.jef.j3p3.DTO.VehicleServicesDTO;
import com.jef.j3p3.entity.VehicleEntity;
import com.jef.j3p3.entity.VehicleServiceEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class VehicleService {

    private LinkedList<VehicleEntity> vehicles = new LinkedList<>();
    private Map<Long, List<VehicleServiceEntity>> vehicleServices = new HashMap<>();

    public void postVehicle(VehicleDTO vDTO) {
        VehicleEntity vehicleEntity = vDTO.DTOtoEntity();
        Long lastId = vehicles.size() > 0 ? 1L+vehicles.getLast().getId() : 0L;
        vehicleEntity.setId(lastId);

        List<VehicleServiceEntity> vehicleServiceEntityList = new ArrayList<>();

        for (VehicleServicesDTO vSDTO: vDTO.getServices()) {
            VehicleServiceEntity vSEntity = VehicleServicesDTO.DTOtoEntity(vSDTO);
            vehicleServiceEntityList.add(vSEntity);
        }

        vehicleServices.put(lastId, vehicleServiceEntityList);


        vehicles.add(vehicleEntity);
    }

    public List<VehicleDTO> getVehicles() {
        return vehicles.stream().map(VehicleDTO::EntityToDTO).collect(Collectors.toList());

    }

    public VehicleDTO getVehicle(Long id) {
        List<VehicleDTO> vehicleDTOList = new ArrayList<>();
        List<VehicleServiceEntity> vehicleServiceEntityList = new ArrayList<>();

        for (VehicleEntity vehicleEntity: vehicles) {
            if (vehicleEntity.getId().equals(id)) {

                List<VehicleServiceEntity> vehicleServiceEntities = new ArrayList<>();
                vehicleServiceEntities = vehicleServices.get(vehicleEntity.getId());

                vehicleDTOList.add(VehicleDTO.EntityToDTOServices(vehicleEntity,
                        vehicleServiceEntities.stream().map(VehicleServicesDTO::EntitytoDTO).collect(Collectors.toList())));

            }
        }


        return vehicleDTOList.size() > 0 ? vehicleDTOList.get(0) : new VehicleDTO();
    }

    public List<VehicleDTO> filterVehicleByDate(LocalDate since, LocalDate to) {
        return vehicles.stream().filter(vehicleEntity -> vehicleEntity.getManufacturingDate().isAfter(since))
                .filter(vehicleEntity -> vehicleEntity.getManufacturingDate().isBefore(to))
                .map(VehicleDTO::EntityToDTO).collect(Collectors.toList());
    }

    public List<VehicleDTO> filterVehicleByPrice(double start, double end) {
        return vehicles.stream().filter(vehicleEntity -> vehicleEntity.getPrice()>= start)
                .filter(vehicleEntity -> vehicleEntity.getPrice() <= end)
                .map(VehicleDTO::EntityToDTO).collect(Collectors.toList());
    }

}
