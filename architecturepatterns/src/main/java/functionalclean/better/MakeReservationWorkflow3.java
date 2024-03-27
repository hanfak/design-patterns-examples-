package functionalclean.better;

import io.vavr.control.Either;

import java.time.Clock;
import java.util.UUID;
import java.util.function.Function;
import java.util.function.Supplier;

public interface MakeReservationWorkflow3 extends Function<Supplier<UUID>, Function<Supplier<Clock>, Function<MakeReservationCommand, Either<MakingReservationFailure, Lending>>>>{

}
