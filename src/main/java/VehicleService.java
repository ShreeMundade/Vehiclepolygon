import java.util.List;

import com.renocrewsolutions.entity.Vehicle;

public interface VehicleService {
    List<Vehicle> getVehiclesForLocation(String location);
    void updateVehiclesInBackground();
}
