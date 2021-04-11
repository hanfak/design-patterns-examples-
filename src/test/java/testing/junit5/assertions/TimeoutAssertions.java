package testing.junit5.assertions;

import org.junit.jupiter.api.Test;

import static java.time.Duration.ofMillis;
import static java.time.Duration.ofMinutes;
import static org.junit.jupiter.api.Assertions.assertTimeout;

public class TimeoutAssertions {
  @Test
  void timeoutNotExceeded()
  {
    //The following assertion succeeds.
    assertTimeout(ofMinutes(2), () -> {
      // Perform task that takes less than 2 minutes.
    });
  }

  @Test
  void timeoutExceeded()
  {
    // The following assertion fails with an error message similar to:
    // execution exceeded timeout of 10 ms by 91 ms
    assertTimeout(ofMillis(10), () -> {
      // Simulate task that takes more than 10 ms.
      Thread.sleep(100);
    });
  }
}
