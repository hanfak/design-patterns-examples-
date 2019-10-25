package testing.clock.example1.better;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.time.Instant;
import java.time.ZoneId;

import static java.time.Clock.fixed;

public class ExampleThreeTest {
  private final Instant now = Instant.now();
  private final ExampleThree exampleThree = new ExampleThree(() -> fixed(now, ZoneId.systemDefault()).instant());

  @Test
  public void name() {
    String milliSecondsFromDate = exampleThree.getMilliSecondsFromDate();
    System.out.println("milliSecondsFromDate = " + milliSecondsFromDate);
    String expected = now.toString().split("\\.")[1];
    Assertions.assertThat(milliSecondsFromDate).isEqualTo(expected);
  }
}