package functionalclean.better;

import java.time.Clock;
import java.time.Instant;
import java.util.UUID;
import java.util.function.Supplier;

public class LendingService3 {
    // Make more testable by passing in the uuid and time
    Lending makeReservation(MakeReservationCommand command, Supplier<UUID> idSupplier, Supplier<Clock> clockSupplier) {
       if (command.customer().active() && command.customer().isNotBehindWithPayments()) {
           if( (command.customer().isVip() && command.reservationDurationInMinutes().value() <= 20) || command.reservationDurationInMinutes().value() <= 5) {
               return new Lending(idSupplier.get(), command.customerId(), command.vehicleId(), command.stationId(), clockSupplier.get().instant(), command.reservationDurationInMinutes(), null, null, null, null, 0);
           } else {
               throw new IllegalArgumentException("Inappropiate duration");
           }
        } else {
           throw new IllegalArgumentException("Customer is not active or is behind with payments");
       }
    }
}
