package com.renocrewsolutions.Impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renocrewsolutions.entity.Vehicle;
import com.renocrewsolutions.repo.VehicleRepository;
import com.renocrewsolutions.service.VehicleService;

@Service
public class VehicleServiceImpl {
    private final VehicleRepository vehicleRepository;
    private final VehicleService vehicleDataFetcher;

    @Autowired
    public VehicleServiceImpl(VehicleRepository vehicleRepository, VehicleService vehicleDataFetcher) {
        this.vehicleRepository = vehicleRepository;
        this.vehicleDataFetcher = vehicleDataFetcher;
    }

    public List<Vehicle> getVehiclesForLocation(String location) {
        return vehicleRepository.getVehiclesByLocation(location);
    }

    public void updateVehiclesInBackground() throws IOException {
        // Implement logic to fetch and update vehicle data from the Open API source
        String updatedVehicles = vehicleDataFetcher.fetchVehicleData();
        vehicleRepository.updateVehicles(updatedVehicles);
    }
}
