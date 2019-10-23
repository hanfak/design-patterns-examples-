package testing.clock.example1.better;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;

public class ExampleOneTest {

  private final Clock clock = Clock.fixed(Instant.now(), ZoneId.systemDefault());

  @Test
  public void name() {
    ExampleOne exampleOne = new ExampleOne(clock);
    String milliSecondsFromDate = exampleOne.getMilliSecondsFromDate();
    System.out.println("milliSecondsFromDate = " + milliSecondsFromDate);
    String expected = clock.instant().toString().split("\\.")[1];
    Assertions.assertThat(milliSecondsFromDate).isEqualTo(expected);
  }
}