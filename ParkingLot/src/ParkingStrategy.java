import java.util.List;
import java.util.Optional;

public interface ParkingStrategy {

    public Optional<ParkingSpot> findSpot(Vehicle vehicle, List<ParkingFloor> floors);
}
