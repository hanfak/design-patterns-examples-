package testing.clock.example1.better;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.time.Instant;

public class ExampleFourTest {

  @Test
  public void name() {
    Instant instant = Instant.parse("2018-11-30T18:35:24.01Z");
    ExampleFour exampleFour = new ExampleFour(() -> instant);
    String milliSecondsFromDate = exampleFour.getMilliSecondsFromDate();
    System.out.println("milliSecondsFromDate = " + milliSecondsFromDate);
    String expected = instant.toString().split("\\.")[1];
    Assertions.assertThat(milliSecondsFromDate).isEqualTo(expected);
  }
}