package functionalclean.better;

import java.time.Clock;
import java.util.UUID;
import java.util.function.Function;

import static functionalclean.better.LendingService5.makeReservationWorkflow;

public class RunnerFor5Partial {

    void execute() {
        Function<MakeReservationCommand, Lending> makingReservationWithRandomIdAndSystemUTCTime = makeReservationWorkflow
                .apply(UUID::randomUUID)
                .apply(Clock::systemUTC);
        makingReservationWithRandomIdAndSystemUTCTime
                .apply(new MakeReservationCommand(
                        new VehicleId("v1"),
                        new StationId("s1"),
                        new CustomerId("c1"),
                        new ReservationDuration(5),
                        new Customer("1", true, false, Customer.Segment.VIP)));
    }

}
