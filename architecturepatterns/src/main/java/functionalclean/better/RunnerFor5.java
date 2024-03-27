package functionalclean.better;

import org.checkerframework.checker.units.qual.C;

import java.time.Clock;
import java.util.UUID;

import static functionalclean.better.LendingService5.makeReservationWorkflow;

public class RunnerFor5 {

    void execute() {
        makeReservationWorkflow
                .apply(UUID::randomUUID)
                .apply(Clock::systemUTC)
                .apply(new MakeReservationCommand(new VehicleId("v1"), new StationId("s1"),
                        new CustomerId("c1"), new ReservationDuration(5),
                        new Customer("1", true, false, Customer.Segment.VIP)));
    }

}
