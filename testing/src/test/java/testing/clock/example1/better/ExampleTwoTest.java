package testing.clock.example1.better;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.mockito.Mockito;

import java.time.Instant;
import java.time.ZoneId;

import static org.mockito.Mockito.when;

public class ExampleTwoTest {
  private final Clock clock = Mockito.mock(Clock.class);
  private final ExampleTwo exampleTwo = new ExampleTwo(clock);

  @Test
  public void name() {
    when(clock.instant()).thenReturn(java.time.Clock.fixed(Instant.now(), ZoneId.systemDefault()).instant());
    String milliSecondsFromDate = exampleTwo.getMilliSecondsFromDate();
    System.out.println("milliSecondsFromDate = " + milliSecondsFromDate);
    String expected = clock.instant().toString().split("\\.")[1];
    Assertions.assertThat(milliSecondsFromDate).isEqualTo(expected);
  }
}