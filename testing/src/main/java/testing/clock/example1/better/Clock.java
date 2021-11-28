package testing.clock.example1.better;

import java.time.Instant;

@FunctionalInterface
public interface Clock {
  Instant instant();
}
