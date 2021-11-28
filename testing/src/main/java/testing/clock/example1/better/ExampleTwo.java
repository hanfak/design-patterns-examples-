package testing.clock.example1.better;

import java.time.Instant;

public class ExampleTwo {
  private final Clock clock;

  public ExampleTwo(Clock clock) {
    this.clock = clock;
  }

  public String getMilliSecondsFromDate() {
    Instant timeNow = clock.instant();
    return timeNow.toString().split("\\.")[1];
  }
}
