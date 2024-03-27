package functionalclean.better;

import java.time.Clock;
import java.util.UUID;
import java.util.function.Function;

import static functionalclean.better.LendingService5.makeReservationWorkflow;
import static functionalclean.better.LendingService6.makeReservationWorkflow2;

public class RunnerFor6 {

    void execute() {
        CustomerRepository c1 = customerId -> {
            // or call to database, or stub like here for testing
            return new Customer("c1", true, false, Customer.Segment.VIP);
        };
        var makingReservationWithRandomIdAndSystemUTCTime = makeReservationWorkflow2
                .apply(UUID::randomUUID)
                .apply(Clock::systemUTC);
        Customer customer = c1.findBy("c1");
        makingReservationWithRandomIdAndSystemUTCTime
                .apply(new MakeReservationCommand(
                        new VehicleId("v1"),
                        new StationId("s1"),
                        new CustomerId("c1"),
                        new ReservationDuration(5),
                        customer));
    }

}
