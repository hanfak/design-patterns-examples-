package functionalclean.better;

import io.vavr.control.Either;

import java.time.Instant;
import java.util.UUID;

public class LendingService7 {

    // the verbosity of the type can be removed to an interface MakeReservationWorkflow
    // Use of the Monad Result, like an Either
    // removes exceptions
   public static MakeReservationWorkflow3 makeReservationWorkflow3 =
        idSupplier -> clockSupplier -> command -> {
            if (command.customer().active() && command.customer().isNotBehindWithPayments()) {
                if ((command.customer().isVip() && command.reservationDurationInMinutes().value() <= 20) ||
                    command.reservationDurationInMinutes().value() <= 5) {
                    return Either.right(new Lending(UUID.randomUUID(), command.customerId(), command.vehicleId(), command.stationId(), Instant.now(), command.reservationDurationInMinutes(), null, null, null, null, 0));
                } else {
                    return Either.left(new MakingReservationFailure.InappropriateDuration());
                }
            } else {
                return Either.left(new MakingReservationFailure.InactiveCustomer());
            }
        };
}

