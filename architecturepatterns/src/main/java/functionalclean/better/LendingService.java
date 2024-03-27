package functionalclean.better;

import java.time.Instant;
import java.util.UUID;

public class LendingService {
    // Removed the IO, and passed the customer as arg -> made more pure (no side effects)
    // Use types for args
    Lending makeReservation(VehicleId vehicleId, StationId stationId, CustomerId customerId, ReservationDuration reservationDurationInMinutes, Customer customer) {
       if (customer.active() && customer.isNotBehindWithPayments()) {
           if( (customer.isVip() && reservationDurationInMinutes.value() <= 20) || reservationDurationInMinutes.value() <= 5) {
               return new Lending(UUID.randomUUID(), customerId, vehicleId, stationId, Instant.now(), reservationDurationInMinutes, null, null, null, null, 0);
           } else {
               throw new IllegalArgumentException("Inappropiate duration");
           }
        } else {
           throw new IllegalArgumentException("Customer is not active or is behind with payments");
       }
    }
}
