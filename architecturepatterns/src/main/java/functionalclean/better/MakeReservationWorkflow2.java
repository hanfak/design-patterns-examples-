package functionalclean.better;

import java.time.Clock;
import java.util.UUID;
import java.util.function.Function;
import java.util.function.Supplier;

public interface MakeReservationWorkflow2 extends Function<Supplier<UUID>, Function<Supplier<Clock>, Function<MakeReservationCommand, Result<MakingReservationFailure, Lending>>>>{

}
