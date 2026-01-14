public class ParkingSpot {

    private final VehicleSize size;
    private boolean isFree;
    private final int spotId;
    private Vehicle parkedVehicle;

    public ParkingSpot(VehicleSize size, int spotId, boolean isFree, Vehicle parkedVehicle){
        this.spotId = spotId;
        this.size = size;
        this.isFree = true;
        this.parkedVehicle = null;
    }

    public int getSpotId(){
        return spotId;
    }

    public boolean isAvailable(){
        return isFree;
    }

    public VehicleSize getSize(){
        return size;
    }

    public void parkVehicle(Vehicle vehicle){
        this.parkedVehicle = vehicle;
        this.isFree = false;
    }

    public void unPark(){
        this.parkedVehicle = null;
        this.isFree=true;
    }

    public boolean canFitVehicle(Vehicle vehicle){
        if(!isAvailable()) return false;

        switch (vehicle.getSize()){
            case SMALL:
                return size == VehicleSize.SMALL;
            case MEDIUM:
                return size == VehicleSize.MEDIUM || size ==VehicleSize.LARGE;
            case LARGE:
                return size == VehicleSize.LARGE;
            default:
                return false;
        }
    }

}
