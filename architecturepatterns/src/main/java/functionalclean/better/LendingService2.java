package functionalclean.better;

import java.time.Instant;
import java.util.UUID;

public class LendingService2 {

    // combine the args into one
    Lending makeReservation(MakeReservationCommand command) {
       if (command.customer().active() && command.customer().isNotBehindWithPayments()) {
           if( (command.customer().isVip() && command.reservationDurationInMinutes().value() <= 20) || command.reservationDurationInMinutes().value() <= 5) {
               return new Lending(UUID.randomUUID(), command.customerId(), command.vehicleId(), command.stationId(), Instant.now(), command.reservationDurationInMinutes(), null, null, null, null, 0);
           } else {
               throw new IllegalArgumentException("Inappropiate duration");
           }
        } else {
           throw new IllegalArgumentException("Customer is not active or is behind with payments");
       }
    }
}
