package testing.clock.example1.old;

import java.time.Instant;


/**
 * Dealing with time can be hard to test. As we have no control over it,
 * Using Instant.now() in prod and test code will lead to different results
 *
 *
 * */
public class ExampleOne {
  public String getMilliSecondsFromDate() {
    Instant timeNow = Instant.now();
    return timeNow.toString().split("\\.")[1];

  }

}
