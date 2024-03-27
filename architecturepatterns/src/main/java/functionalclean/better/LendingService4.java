package functionalclean.better;

import java.time.Clock;
import java.time.Instant;
import java.util.UUID;
import java.util.function.Function;
import java.util.function.Supplier;

public class LendingService4 {

    // Use of currying to pass in the idSupplier and clockSupplier,
    // idSupp -> clockSupplier -> MakeReservationCommand -> Lending
    // Create a function, but the type is verbose
    Function<Supplier<UUID>, Function<Supplier<Clock>, Function<MakeReservationCommand, Lending>>> makeReservation =
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

