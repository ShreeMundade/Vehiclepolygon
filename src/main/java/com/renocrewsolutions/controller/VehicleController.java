package com.renocrewsolutions.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.renocrewsolutions.entity.Vehicle;
import com.renocrewsolutions.service.VehicleService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class VehicleController {

    private final VehicleService vehicleDataFetcherService;

    @Autowired
    public VehicleController(VehicleService vehicleDataFetcherService) {
        this.vehicleDataFetcherService = vehicleDataFetcherService;
    }

    @GetMapping("/vehicles")
    public List<Vehicle> getVehicles() {
        try {
            // Fetch vehicle data from the Open API
            String vehicleDataJson = vehicleDataFetcherService.fetchVehicleData();

            ObjectMapper objectMapper = new ObjectMapper();
            List<Vehicle> vehicles = objectMapper.readValue(vehicleDataJson, new TypeReference<List<Vehicle>>() {
            });

            return vehicles;
        } catch (IOException e) {

            e.printStackTrace(); 
            return null; 
        }
    }
}
