import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class ParkingLot {

    private static ParkingLot instance;
    private final Map<String, Ticket> activeTickets;
    private final List<ParkingFloor> floors = new ArrayList<>();
    private FeeStrategy feeStrategy;
    private ParkingStrategy parkingStrategy;

    private ParkingLot(){
        this.feeStrategy = new FixedRateStrategy();
        this.activeTickets = new ConcurrentHashMap<>();
        this.parkingStrategy = new NearestFirstStrategy();
    }

    public static synchronized ParkingLot getInstance(){
        if(instance == null){
            instance = new ParkingLot();
        }
        return instance;
    }

    public void addFloor(ParkingFloor floor){
        floors.add(floor);
    }

    public void setFeeStrategy(FeeStrategy feeStrategy) {
        this.feeStrategy = feeStrategy;
    }

    public void setParkingStrategy(ParkingStrategy parkingStrategy) {
        this.parkingStrategy = parkingStrategy;
    }

    public Optional<Ticket> parkVehicle(Vehicle vehicle){
        Optional<ParkingSpot> availableSpot = parkingStrategy.findSpot(vehicle, floors);

        if(availableSpot.isPresent()){
                ParkingSpot spot = availableSpot.get();
                spot.parkVehicle(vehicle);
                Ticket parkingTicket = new Ticket(vehicle, spot);
                activeTickets.put(vehicle.getLicenseNumber(), parkingTicket);
                System.out.printf("%s parked at %s. Ticket: %s\n", vehicle.getLicenseNumber(), spot.getSpotId(), parkingTicket.getTicketId());
                return Optional.of(parkingTicket);
        }

        System.out.println("Sorry, Parking Full !!");
        return Optional.empty();
    }

    public Optional<Double> unParkVehicle(String licenseNumber){
        Ticket ticket = activeTickets.remove(licenseNumber);
        if(ticket == null){
            System.out.println("No Ticket Found !");
            return Optional.empty();
        }

        ticket.setExitTime();
        ticket.getParkingSpot().unPark();

        Double fee = feeStrategy.calculateFee(ticket);

        return Optional.of(fee);
    }


}
