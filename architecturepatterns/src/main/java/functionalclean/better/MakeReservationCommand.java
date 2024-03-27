package functionalclean.better;

public record MakeReservationCommand(
        VehicleId vehicleId,
        StationId stationId,
        CustomerId customerId,
        ReservationDuration reservationDurationInMinutes,
        Customer customer
) {

    // Can have validation
    public MakeReservationCommand {
        if (anyIsNull(vehicleId, stationId, customerId, customer)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean anyIsNull(VehicleId vehicleId, StationId stationId, CustomerId customerId, Customer customer) {
        return vehicleId == null ||
               stationId == null ||
               customerId == null ||
               customer == null;
    }
}
