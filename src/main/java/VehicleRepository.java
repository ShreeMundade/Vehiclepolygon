import java.util.List;

import com.renocrewsolutions.entity.Vehicle;

public interface VehicleRepository {
    List<Vehicle> getVehiclesByLocation(String location);
    void updateVehicles(List<Vehicle> vehicles);
}
