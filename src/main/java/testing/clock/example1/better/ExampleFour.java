package testing.clock.example1.better;

import java.time.Instant;


public class ExampleFour {
  private final Clock clock;

  public ExampleFour(Clock clock) {
    this.clock = clock;
  }

  public String getMilliSecondsFromDate() {
    Instant timeNow = clock.instant();
    return timeNow.toString().split("\\.")[1]; // This does not work if there is 0milliseconds
  }
}
