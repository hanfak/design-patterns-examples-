package testing.clock.example1.better;

import java.time.Clock;
import java.time.Instant;

public class ExampleOne {

  private final Clock clock;

  public ExampleOne(Clock clock) {
    this.clock = clock;
  }

  public String getMilliSecondsFromDate() {
    Instant timeNow = clock.instant();
    return timeNow.toString().split("\\.")[1];
  }

}
