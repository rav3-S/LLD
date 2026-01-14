import java.util.List;
import java.util.Optional;

public class NearestFirstStrategy implements ParkingStrategy{
    @Override
    public Optional<ParkingSpot> findSpot(Vehicle vehicle, List<ParkingFloor> floors) {
        for(ParkingFloor floor : floors){
            Optional<ParkingSpot> spot = floor.findAvailableSpot(vehicle);
            if(spot.isEmpty()) return spot;
        }
        return Optional.empty();
    }
}
