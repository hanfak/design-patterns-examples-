package functionalclean.better;

import java.time.Instant;
import java.util.UUID;

public class LendingService6 {

    // the verbosity of the type can be removed to an interface MakeReservationWorkflow
    // Use of the Monad Result, like an Either
    // removes exceptions
   public static MakeReservationWorkflow2 makeReservationWorkflow2 =
        idSupplier -> clockSupplier -> command -> {
            if (command.customer().active() && command.customer().isNotBehindWithPayments()) {
                if ((command.customer().isVip() && command.reservationDurationInMinutes().value() <= 20) ||
                    command.reservationDurationInMinutes().value() <= 5) {
                    return Result.success(new Lending(UUID.randomUUID(), command.customerId(), command.vehicleId(), command.stationId(), Instant.now(), command.reservationDurationInMinutes(), null, null, null, null, 0));
                } else {
                    return Result.failure(new MakingReservationFailure.InappropriateDuration());
                }
            } else {
                return Result.failure(new MakingReservationFailure.InactiveCustomer());
            }
        };
}

