public class FixedRateStrategy implements FeeStrategy{

    private static final double FIXED_RATE = 10.0;

    @Override
    public double calculateFee(Ticket ticket) {
        long duration = ticket.getExitTime() - ticket.getEntryTime();
        long hours = (duration / (1000 * 60 * 60)) + 1;
        return hours * FIXED_RATE;
    }
}
