import java.util.Comparator;
import java.util.Map;
import java.util.Optional;

public class ParkingFloor {

    private int floorNumber;
    private Map<Integer, ParkingSpot> spots;

    public ParkingFloor(int floorNumber){
        this.floorNumber=floorNumber;
    }
    public void addSpot(ParkingSpot spot){
        spots.put(spot.getSpotId(), spot);
    }

    public synchronized Optional<ParkingSpot> findAvailableSpot(Vehicle vehicle){
        return spots.values().stream()
                .filter(spot -> spot.isAvailable() && spot.canFitVehicle(vehicle))
                .sorted(Comparator.comparing(ParkingSpot::getSize))
                .findFirst();
    }


}
