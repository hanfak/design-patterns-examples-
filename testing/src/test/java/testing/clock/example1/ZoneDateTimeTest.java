package testing.clock.example1;

import org.junit.Test;

import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ZoneDateTimeTest {
  @Test
  public void looksLikeItReturnsNow() {
    assertThat(new ClockI().getZonedDateTime()).isAfterOrEqualTo(ZonedDateTime.now().minus(Duration.ofSeconds(1)));
  }

  @Test
  public void clockUserExample() {
    Clock clockMock = mock(Clock.class);
    when(clockMock.getZonedDateTime()).thenReturn(ZonedDateTime.now());
    new ClockUser(clockMock).blah();
    Clock clockSupplier = () -> ZonedDateTime.of(2019,12,3,2,43,12,0, ZoneId.systemDefault());
    new ClockUser(clockSupplier).blah();
  }
}

@FunctionalInterface
interface Clock {
  ZonedDateTime getZonedDateTime();
}

class ClockI implements Clock {
  @Override
  public ZonedDateTime getZonedDateTime() {
    return ZonedDateTime.now();
  }
}

class ClockUser {
  private final Clock clock;

  ClockUser(Clock clock) {
    this.clock = clock;
  }

  public void blah() {
    ZonedDateTime zonedDateTime = clock.getZonedDateTime();
    System.out.println(zonedDateTime);
  }
}

class main {
  public static void main(String... args) {
    new ClockUser(new ClockI()).blah();
  }
}
