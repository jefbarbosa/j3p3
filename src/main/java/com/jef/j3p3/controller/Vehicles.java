package com.jef.j3p3.controller;

import com.jef.j3p3.DTO.VehicleDTO;
import com.jef.j3p3.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/v1/api/vehicles")
public class Vehicles {

    private VehicleService vehicleService;

    public Vehicles(@Autowired VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping
    public ResponseEntity<String> postVehicles(@RequestBody VehicleDTO vehicleDTO) {

        vehicleService.postVehicle(vehicleDTO);

        return new ResponseEntity<>("OK", HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<List<VehicleDTO>> getVehicles(){
        return new ResponseEntity<>(vehicleService.getVehicles(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleDTO> searchVehicle(@PathVariable Long id) {
        return new ResponseEntity<>(vehicleService.getVehicle(id), HttpStatus.OK);
    }

    @GetMapping("/dates")
    public ResponseEntity<List<VehicleDTO>> filterVehicleByDate(
            @RequestParam("since") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate since,
            @RequestParam("to") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to) {
        
        return new ResponseEntity<>(vehicleService.filterVehicleByDate(since, to), HttpStatus.OK);
    }

    @GetMapping("/prices")
    public ResponseEntity<List<VehicleDTO>> filterVehicleByPrice(@RequestParam double start, @RequestParam double end) {
        return new ResponseEntity<>(vehicleService.filterVehicleByPrice(start, end), HttpStatus.OK);
    }

}
