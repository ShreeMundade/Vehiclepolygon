package com.renocrewsolutions.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.renocrewsolutions.entity.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle ,Long >{

	void updateVehicles(String updatedVehicles);

	List<Vehicle> getVehiclesByLocation(String location);

	void updateVehicles(List<Vehicle> updatedVehicles);
	

}
