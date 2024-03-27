package functionalclean.better;

import io.vavr.control.Either;

import java.time.Clock;
import java.util.UUID;
import java.util.function.Function;

import static functionalclean.better.LendingService6.makeReservationWorkflow2;
import static functionalclean.better.LendingService7.makeReservationWorkflow3;

public class RunnerFor7 {

    void execute() {
        CustomerRepository2 c1 = customerId -> {
            // or call to database, or stub like here for testing
            return Either.right(new Customer("c1", true, false, Customer.Segment.VIP));
        };
        var makingReservationWithRandomIdAndSystemUTCTime = makeReservationWorkflow3
                .apply(UUID::randomUUID)
                .apply(Clock::systemUTC);
        Either<DatabaseFailure, Customer> customer = c1.findBy("c1");
        Either<DatabaseFailure, Either<MakingReservationFailure, Lending>> map = customer.map(c ->
                makingReservationWithRandomIdAndSystemUTCTime
                        .apply(new MakeReservationCommand(
                                new VehicleId("v1"),
                                new StationId("s1"),
                                new CustomerId("c1"),
                                new ReservationDuration(5),
                                c)));
        Either<DatabaseFailure, Boolean> bimap = map.bimap(
                Function.identity(),
                it -> new LendingRepository2().save(it.get())
        );
    }

}
