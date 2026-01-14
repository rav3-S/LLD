import java.util.Date;
import java.util.UUID;

public class Ticket {

    private final String ticketId;
    private final long entryTime;
    private final Vehicle vehicle;
    private final ParkingSpot parkingSpot;
    private long exitTime;

    public Ticket(Vehicle vehicle, ParkingSpot parkingSpot){
        this.ticketId = UUID.randomUUID().toString();
        this.vehicle=vehicle;
        this.entryTime = new Date().getTime();
        this.parkingSpot = parkingSpot;
    }

    public void setExitTime() {
        this.exitTime = new Date().getTime();
    }

    public String getTicketId() {
        return ticketId;
    }

    public long getEntryTime() {
        return entryTime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public long getExitTime() {
        return exitTime;
    }
}
