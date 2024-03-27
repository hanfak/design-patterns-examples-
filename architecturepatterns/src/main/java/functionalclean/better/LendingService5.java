package functionalclean.better;

import java.time.Clock;
import java.time.Instant;
import java.util.UUID;
import java.util.function.Function;
import java.util.function.Supplier;

public class LendingService5 {

    // the verbosity of the type can be removed to an interface MakeReservationWorkflow
   public static MakeReservationWorkflow makeReservationWorkflow =
        idSupplier -> clockSupplier -> command -> {
            if (command.customer().active() && command.customer().isNotBehindWithPayments()) {
                if ((command.customer().isVip() && command.reservationDurationInMinutes().value() <= 20) ||
                    command.reservationDurationInMinutes().value() <= 5) {
                    return new Lending(UUID.randomUUID(), command.customerId(), command.vehicleId(), command.stationId(), Instant.now(), command.reservationDurationInMinutes(), null, null, null, null, 0);
                } else {
                    throw new IllegalArgumentException("Inappropiate duration");
                }
            } else {
                throw new IllegalArgumentException("Customer is not active or is behind with payments");
            }
        };
}

