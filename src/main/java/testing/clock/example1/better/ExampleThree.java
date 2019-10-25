package testing.clock.example1.better;

import java.time.Instant;

public class ExampleThree {
  private final Clock clock;

  public ExampleThree(Clock clock) {
    this.clock = clock;
  }

  public String getMilliSecondsFromDate() {
    Instant timeNow = clock.instant();
    return timeNow.toString().split("\\.")[1];
  }
}
